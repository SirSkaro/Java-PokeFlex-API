package skaro.pokeflex.api;

import java.io.IOException;

public interface PokeFlexRequest
{
	public Endpoint getEndpoint();
	public Object makeRequest(PokeFlexFactory factory) throws IOException, PokeFlexException;
}
