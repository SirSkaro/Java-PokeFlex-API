
package skaro.pokeflex.objects.set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hp",
    "atk",
    "def",
    "spatk",
    "spdef",
    "spd"
})
public class Evs {

    @JsonProperty("hp")
    private int hp;
    @JsonProperty("atk")
    private int atk;
    @JsonProperty("def")
    private int def;
    @JsonProperty("spatk")
    private int spatk;
    @JsonProperty("spdef")
    private int spdef;
    @JsonProperty("spd")
    private int spd;

    @JsonProperty("hp")
    public int getHp() {
        return hp;
    }

    @JsonProperty("hp")
    public void setHp(int hp) {
        this.hp = hp;
    }

    @JsonProperty("atk")
    public int getAtk() {
        return atk;
    }

    @JsonProperty("atk")
    public void setAtk(int atk) {
        this.atk = atk;
    }

    @JsonProperty("def")
    public int getDef() {
        return def;
    }

    @JsonProperty("def")
    public void setDef(int def) {
        this.def = def;
    }

    @JsonProperty("spatk")
    public int getSpatk() {
        return spatk;
    }

    @JsonProperty("spatk")
    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    @JsonProperty("spdef")
    public int getSpdef() {
        return spdef;
    }

    @JsonProperty("spdef")
    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    @JsonProperty("spd")
    public int getSpd() {
        return spd;
    }

    @JsonProperty("spd")
    public void setSpd(int spd) {
        this.spd = spd;
    }

}
