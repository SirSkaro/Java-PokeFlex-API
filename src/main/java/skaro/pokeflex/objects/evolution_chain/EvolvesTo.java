
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
public class EvolvesTo {

    @JsonProperty("evolution_details")
    private List<EvolutionDetail> evolutionDetails = null;
    @JsonProperty("evolves_to")
    private List<EvolvesTo_> evolvesTo = null;
    @JsonProperty("is_baby")
    private boolean isBaby;
    @JsonProperty("species")
    private Species_ species;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("evolution_details")
    public List<EvolutionDetail> getEvolutionDetails() {
        return evolutionDetails;
    }

    @JsonProperty("evolution_details")
    public void setEvolutionDetails(List<EvolutionDetail> evolutionDetails) {
        this.evolutionDetails = evolutionDetails;
    }

    @JsonProperty("evolves_to")
    public List<EvolvesTo_> getEvolvesTo() {
        return evolvesTo;
    }

    @JsonProperty("evolves_to")
    public void setEvolvesTo(List<EvolvesTo_> evolvesTo) {
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
    public Species_ getSpecies() {
        return species;
    }

    @JsonProperty("species")
    public void setSpecies(Species_ species) {
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
