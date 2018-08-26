package skaro.pokeflex.api;

import java.util.ArrayList;
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
	
	public Request(Endpoint ep)
	{
		endpoint = ep;
		urlParams = new ArrayList<String>();
	}
	
	public void addParam(String s)
	{
		urlParams.add(s);
	}

	public Endpoint getEndpoint() { return endpoint; }
	public List<String> getUrlParams() { return urlParams; }
}
