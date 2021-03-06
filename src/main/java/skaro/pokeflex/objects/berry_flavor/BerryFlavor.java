
package skaro.pokeflex.objects.berry_flavor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import skaro.pokeflex.api.IFlexObject;
import skaro.pokeflex.objects.ability.Name;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "berries",
    "names",
    "id",
    "contest_type",
    "name"
})
public class BerryFlavor implements IFlexObject {

    @JsonProperty("berries")
    private List<Berry> berries = null;
    @JsonProperty("names")
    private List<Name> names = null;
    @JsonProperty("id")
    private int id;
    @JsonProperty("contest_type")
    private ContestType contestType;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("berries")
    public List<Berry> getBerries() {
        return berries;
    }

    @JsonProperty("berries")
    public void setBerries(List<Berry> berries) {
        this.berries = berries;
    }

    @JsonProperty("names")
    public List<Name> getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(List<Name> names) {
        this.names = names;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("contest_type")
    public ContestType getContestType() {
        return contestType;
    }

    @JsonProperty("contest_type")
    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
	public String getNameInLanguage(String lang)
	{
		for(Name nm : this.names)
		{
			if(nm.getLanguage().getName().equals(lang))
				return nm.getName();
		}
		
		return name;
	}

}
