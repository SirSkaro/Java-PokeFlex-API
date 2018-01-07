
package skaro.pokeflex.objects.evolution_chain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "evolution_details",
    "evolves_to",
    "is_baby",
    "species"
})
public class Chain {

    @JsonProperty("evolution_details")
    private List<Object> evolutionDetails = null;
    @JsonProperty("evolves_to")
    private List<EvolvesTo> evolvesTo = null;
    @JsonProperty("is_baby")
    private boolean isBaby;
    @JsonProperty("species")
    private Species__ species;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("evolution_details")
    public List<Object> getEvolutionDetails() {
        return evolutionDetails;
    }

    @JsonProperty("evolution_details")
    public void setEvolutionDetails(List<Object> evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    @JsonProperty("evolves_to")
    public List<EvolvesTo> getEvolvesTo() {
        return evolvesTo;
    }

    @JsonProperty("evolves_to")
    public void setEvolvesTo(List<EvolvesTo> evolvesTo) {
        this.evolvesTo = evolvesTo;
    }

    @JsonProperty("is_baby")
    public boolean isIsBaby() {
        return isBaby;
    }

    @JsonProperty("is_baby")
    public void setIsBaby(boolean isBaby) {
        this.isBaby = isBaby;
    }

    @JsonProperty("species")
    public Species__ getSpecies() {
        return species;
    }

    @JsonProperty("species")
    public void setSpecies(Species__ species) {
        this.species = species;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
