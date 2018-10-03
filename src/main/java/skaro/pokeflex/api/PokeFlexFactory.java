package skaro.pokeflex.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PokeFlexFactory 
{
	private String baseURI;
	private ObjectMapper mapper;
	private ExecutorService threadPool;

	public PokeFlexFactory(String base)
	{
		baseURI = base;
		mapper = new ObjectMapper();
		threadPool = Executors.newFixedThreadPool(8);
	}
	
	public PokeFlexFactory(String base, ExecutorService customExecutor)
	{
		baseURI = base;
		mapper = new ObjectMapper();
		threadPool = customExecutor;
	}

	public Object createFlexObject(Endpoint endpoint, List<String> params) throws IOException, PokeFlexException
	{
		Optional<URL> url = constructURL(endpoint.getEnpoint(), params);
		Class<?> wrapperClass = endpoint.getWrapperClass();
		Object jsonPOJO;
		String json;

		if(!url.isPresent())
			throw new PokeFlexException("Unable to create URL for request");

		json = getJSONFromURL(url.get());
		jsonPOJO = mapper.readValue(json, wrapperClass);
		return wrapperClass.cast(jsonPOJO);
	}
	
	public Object createFlexObject(String url, Endpoint endpoint) throws IOException, PokeFlexException
	{
		List<String> params = getURLParams(url, endpoint);
		return createFlexObject(endpoint, params);
	}
	
	public Object createFlexObject(Request request) throws IOException, PokeFlexException
	{
		return createFlexObject(request.getEndpoint(), request.getUrlParams());
	}
	
	public Object createFlexObject(RequestURL request) throws IOException, PokeFlexException
	{
		return createFlexObject(request.getURL(), request.getEndpoint());
	}

	public List<Object> createFlexObjects(List<PokeFlexRequest> requests) throws InterruptedException, PokeFlexException
	{
		List<Object> result = new ArrayList<Object>();
		List<Future<Object>> flexResults = new ArrayList<Future<Object>>();
		Future<Object> requestResult;
		
		for(PokeFlexRequest request : requests)
		{
			requestResult = threadPool.submit(new Callable<Object>()
			{	@Override
				public Object call() throws Exception { return request.makeRequest(PokeFlexFactory.this);}
			});
			
			flexResults.add(requestResult);
		}
		
		for(Future<Object> flexObj : flexResults)
		{
			try { result.add(flexObj.get()); } 
			catch (ExecutionException e) { throw new PokeFlexException("Could not fulfill all requests."); }
		}
		
		return result;
	}
	
	private Optional<URL> constructURL(String endpoint, List<String> args)
	{
		Optional<URL> result;
		URL url;
		StringBuilder builder = new StringBuilder(baseURI);
		String builtURL;

		//Construct URL
		builder.append("/");
		builder.append(endpoint);
		builder.append("/");
		for(String arg: args)
		{
			builder.append(arg);
			builder.append("/");
		}

		//Build the URL
		builtURL = builder.substring(0, builder.lastIndexOf("/"));
		try 
		{
			url = new URL(builtURL);
			result = Optional.of(url);
		} 
		catch(MalformedURLException e) 
		{
			System.err.println(e.getMessage());
			result = Optional.empty();
		}

		return result;
	}

	private String getJSONFromURL(URL url) throws IOException
	{
		String htmlContent, jsonText;

		htmlContent = readContentFromUrl(url);
		jsonText = filterHTML(htmlContent);

		return jsonText;
	}

	private String filterHTML(String htmlContent)
	{
		String filteredContent = Jsoup.parse(htmlContent).text();
		int jsonStartBracketIndex = filteredContent.indexOf("{");
		int jsonEndBracketIndex = filteredContent.lastIndexOf("}");

		return filteredContent.substring(jsonStartBracketIndex, jsonEndBracketIndex + 1); 
	}

	private String readContentFromUrl(URL url) throws IOException 
	{
		InputStream is = url.openStream();
		try 
		{
			BufferedReader rd = new BufferedReader
					(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readBufferToString(rd);
			return jsonText;
		} 
		finally 
		{
			is.close();
		}
	}

	private String readBufferToString(Reader rd) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		int cp;
		while((cp = rd.read()) != -1) 
		{
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	private List<String> getURLParams(String url, Endpoint endpoint)
	{
		List<String> result = new ArrayList<String>();
		String[] elements = url.split("/");
		int itr;
		
		for(itr = 0; itr < elements.length; itr++)
		{
			if(elements[itr].equals(endpoint.getEnpoint()))
				break;
		}
		
		if(elements.length <= (itr+1))
			return result;			//no url parameters
		
		for(itr = itr + 1; itr < elements.length; itr++)
			result.add(elements[itr]);
		
		return result;
	}
}
