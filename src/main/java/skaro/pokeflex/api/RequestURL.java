package skaro.pokeflex.api;

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
}
