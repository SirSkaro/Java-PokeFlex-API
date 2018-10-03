package skaro.pokeflex.api;

import java.io.IOException;

public class RequestURL implements PokeFlexRequest
{
	private String url;
	private Endpoint endpoint;
	
	public RequestURL(String url, Endpoint endpoint)
	{
		this.url = url;
		this.endpoint = endpoint;
	}
	
	public String getURL() { return url; }
	public Endpoint getEndpoint() { return endpoint; }
	
	@Override
	public Object makeRequest(PokeFlexFactory factory) throws IOException, PokeFlexException
	{
		return factory.createFlexObject(this);
	}
}
