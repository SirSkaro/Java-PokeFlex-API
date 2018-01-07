
package skaro.pokeflex.objects.type;

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
    "half_damage_from",
    "no_damage_from",
    "half_damage_to",
    "double_damage_from",
    "no_damage_to",
    "double_damage_to"
})
public class DamageRelations {

    @JsonProperty("half_damage_from")
    private List<Object> halfDamageFrom = null;
    @JsonProperty("no_damage_from")
    private List<NoDamageFrom> noDamageFrom = null;
    @JsonProperty("half_damage_to")
    private List<HalfDamageTo> halfDamageTo = null;
    @JsonProperty("double_damage_from")
    private List<DoubleDamageFrom> doubleDamageFrom = null;
    @JsonProperty("no_damage_to")
    private List<NoDamageTo> noDamageTo = null;
    @JsonProperty("double_damage_to")
    private List<Object> doubleDamageTo = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("half_damage_from")
    public List<Object> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    @JsonProperty("half_damage_from")
    public void setHalfDamageFrom(List<Object> halfDamageFrom) {
        this.halfDamageFrom = halfDamageFrom;
    }

    @JsonProperty("no_damage_from")
    public List<NoDamageFrom> getNoDamageFrom() {
        return noDamageFrom;
    }

    @JsonProperty("no_damage_from")
    public void setNoDamageFrom(List<NoDamageFrom> noDamageFrom) {
        this.noDamageFrom = noDamageFrom;
    }

    @JsonProperty("half_damage_to")
    public List<HalfDamageTo> getHalfDamageTo() {
        return halfDamageTo;
    }

    @JsonProperty("half_damage_to")
    public void setHalfDamageTo(List<HalfDamageTo> halfDamageTo) {
        this.halfDamageTo = halfDamageTo;
    }

    @JsonProperty("double_damage_from")
    public List<DoubleDamageFrom> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    @JsonProperty("double_damage_from")
    public void setDoubleDamageFrom(List<DoubleDamageFrom> doubleDamageFrom) {
        this.doubleDamageFrom = doubleDamageFrom;
    }

    @JsonProperty("no_damage_to")
    public List<NoDamageTo> getNoDamageTo() {
        return noDamageTo;
    }

    @JsonProperty("no_damage_to")
    public void setNoDamageTo(List<NoDamageTo> noDamageTo) {
        this.noDamageTo = noDamageTo;
    }

    @JsonProperty("double_damage_to")
    public List<Object> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    @JsonProperty("double_damage_to")
    public void setDoubleDamageTo(List<Object> doubleDamageTo) {
        this.doubleDamageTo = doubleDamageTo;
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
