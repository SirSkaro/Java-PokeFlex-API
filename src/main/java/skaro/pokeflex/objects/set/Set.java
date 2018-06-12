
package skaro.pokeflex.objects.set;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sets",
    "gen",
    "url",
    "tier",
    "name"
})
public class Set {

    @JsonProperty("sets")
    private List<Set_> sets = null;
    @JsonProperty("gen")
    private int gen;
    @JsonProperty("url")
    private String url;
    @JsonProperty("tier")
    private String tier;
    @JsonProperty("name")
    private String name;

    @JsonProperty("sets")
    public List<Set_> getSets() {
        return sets;
    }

    @JsonProperty("sets")
    public void setSets(List<Set_> sets) {
        this.sets = sets;
    }

    @JsonProperty("gen")
    public int getGen() {
        return gen;
    }

    @JsonProperty("gen")
    public void setGen(int gen) {
        this.gen = gen;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("tier")
    public String getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(String tier) {
        this.tier = tier;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

}
