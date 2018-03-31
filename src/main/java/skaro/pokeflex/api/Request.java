package skaro.pokeflex.api;

import java.util.List;

public class Request 
{
	private Endpoint endpoint;
	private List<String> urlParams;
	
	public Request(Endpoint ep, List<String> params)
	{
		endpoint = ep;
		urlParams = params;
	}

	public Endpoint getEndpoint() { return endpoint; }
	public List<String> getUrlParams() { return urlParams; }
}
