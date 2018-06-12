
package skaro.pokeflex.objects.set;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "level",
    "ability",
    "item",
    "moves",
    "title",
    "nature",
    "ivs",
    "evs"
})
public class Set_ {

    @JsonProperty("level")
    private int level;
    @JsonProperty("ability")
    private String ability;
    @JsonProperty("item")
    private String item;
    @JsonProperty("moves")
    private List<String> moves = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("nature")
    private String nature;
    @JsonProperty("ivs")
    private Ivs ivs;
    @JsonProperty("evs")
    private Evs evs;

    @JsonProperty("level")
    public int getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(int level) {
        this.level = level;
    }

    @JsonProperty("ability")
    public String getAbility() {
        return ability;
    }

    @JsonProperty("ability")
    public void setAbility(String ability) {
        this.ability = ability;
    }

    @JsonProperty("item")
    public String getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(String item) {
        this.item = item;
    }

    @JsonProperty("moves")
    public List<String> getMoves() {
        return moves;
    }

    @JsonProperty("moves")
    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("nature")
    public String getNature() {
        return nature;
    }

    @JsonProperty("nature")
    public void setNature(String nature) {
        this.nature = nature;
    }

    @JsonProperty("ivs")
    public Ivs getIvs() {
        return ivs;
    }

    @JsonProperty("ivs")
    public void setIvs(Ivs ivs) {
        this.ivs = ivs;
    }

    @JsonProperty("evs")
    public Evs getEvs() {
        return evs;
    }

    @JsonProperty("evs")
    public void setEvs(Evs evs) {
        this.evs = evs;
    }

}
