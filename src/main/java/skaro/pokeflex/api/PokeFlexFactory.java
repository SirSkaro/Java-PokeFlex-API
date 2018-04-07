package skaro.pokeflex.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PokeFlexFactory 
{
	private String baseURI;
	private ObjectMapper mapper;
	
	public PokeFlexFactory(String base)
	{
		baseURI = base;
		mapper = new ObjectMapper();
	}
	
	public Object createFlexObject(Endpoint endpoint, List<String> args) throws IOException, PokeFlexException
	{
		Optional<URL> url = constructURL(endpoint.getEnpoint(), args);
		Class<?> wrapperClass = endpoint.getWrapperClass();
		Object jsonPOJO;
		String json;
		
		
		if(!url.isPresent())
			throw new PokeFlexException("Unable to create URL for request");
		
		json = getJSONFromURL(url.get());
		jsonPOJO = mapper.readValue(json, wrapperClass);
		return wrapperClass.cast(jsonPOJO);
	}
	
	public Object createFlexObject(Request request) throws IOException, PokeFlexException
	{
		return createFlexObject(request.getEndpoint(), request.getUrlParams());
	}
	
	public List<Object> createFlexObjects(List<Endpoint> endpoints, List<List<String>> urlParamsList) throws InterruptedException, PokeFlexException
	{
		if(endpoints.size() != urlParamsList.size())
			throw new IllegalArgumentException("List arguments must be of equal length");
		
		List<Thread> threads = new ArrayList<Thread>();
		List<Object> result = new ArrayList<Object>();
		for(int i = 0; i < endpoints.size(); i++)
		{
			int id = i;
			Thread thread = new Thread()
				{
					public void run()
					{
						Object flexObj;
						try  { flexObj = createFlexObject(endpoints.get(id), urlParamsList.get(id)); } 
						catch (IOException | PokeFlexException e) { flexObj = null; }
						
						synchronized(result)
						{
							result.add(flexObj);
						}
					}
				};
			
			thread.start();
			threads.add(thread);
		}
		
		for(Thread thread : threads)
			thread.join();
		
		for(Object obj : result)
			if(obj == null)
				throw new PokeFlexException("Could not fulfill all requests.");
		
		return result;
	}
	
	public List<Object> createFlexObjects(List<Request> requests) throws InterruptedException, PokeFlexException
	{
		List<List<String>> urlParamsList = new ArrayList<List<String>>();
		List<Endpoint> endpoints = new ArrayList<Endpoint>();
		
		for(Request req : requests)
		{
			urlParamsList.add(req.getUrlParams());
			endpoints.add(req.getEndpoint());
		}
		
		return createFlexObjects(endpoints, urlParamsList);
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
}
