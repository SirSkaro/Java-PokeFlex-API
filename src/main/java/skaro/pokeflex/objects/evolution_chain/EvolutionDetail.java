
package skaro.pokeflex.objects.evolution_chain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "min_level",
    "min_beauty",
    "time_of_day",
    "gender",
    "relative_physical_stats",
    "needs_overworld_rain",
    "turn_upside_down",
    "item",
    "trigger",
    "known_move_type",
    "min_affection",
    "party_type",
    "trade_species",
    "party_species",
    "min_happiness",
    "held_item",
    "known_move",
    "location"
})
public class EvolutionDetail {

    @JsonProperty("min_level")
    private int minLevel;
    @JsonProperty("min_beauty")
    private Object minBeauty;
    @JsonProperty("time_of_day")
    private String timeOfDay;
    @JsonProperty("gender")
    private Object gender;
    @JsonProperty("relative_physical_stats")
    private Object relativePhysicalStats;
    @JsonProperty("needs_overworld_rain")
    private boolean needsOverworldRain;
    @JsonProperty("turn_upside_down")
    private boolean turnUpsideDown;
    @JsonProperty("item")
    private Object item;
    @JsonProperty("trigger")
    private Trigger trigger;
    @JsonProperty("known_move_type")
    private Object knownMoveType;
    @JsonProperty("min_affection")
    private Object minAffection;
    @JsonProperty("party_type")
    private Object partyType;
    @JsonProperty("trade_species")
    private Object tradeSpecies;
    @JsonProperty("party_species")
    private Object partySpecies;
    @JsonProperty("min_happiness")
    private Object minHappiness;
    @JsonProperty("held_item")
    private Object heldItem;
    @JsonProperty("known_move")
    private Object knownMove;
    @JsonProperty("location")
    private Object location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("min_level")
    public int getMinLevel() {
        return minLevel;
    }

    @JsonProperty("min_level")
    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    @JsonProperty("min_beauty")
    public Object getMinBeauty() {
        return minBeauty;
    }

    @JsonProperty("min_beauty")
    public void setMinBeauty(Object minBeauty) {
        this.minBeauty = minBeauty;
    }

    @JsonProperty("time_of_day")
    public String getTimeOfDay() {
        return timeOfDay;
    }

    @JsonProperty("time_of_day")
    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @JsonProperty("gender")
    public Object getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Object gender) {
        this.gender = gender;
    }

    @JsonProperty("relative_physical_stats")
    public Object getRelativePhysicalStats() {
        return relativePhysicalStats;
    }

    @JsonProperty("relative_physical_stats")
    public void setRelativePhysicalStats(Object relativePhysicalStats) {
        this.relativePhysicalStats = relativePhysicalStats;
    }

    @JsonProperty("needs_overworld_rain")
    public boolean isNeedsOverworldRain() {
        return needsOverworldRain;
    }

    @JsonProperty("needs_overworld_rain")
    public void setNeedsOverworldRain(boolean needsOverworldRain) {
        this.needsOverworldRain = needsOverworldRain;
    }

    @JsonProperty("turn_upside_down")
    public boolean isTurnUpsideDown() {
        return turnUpsideDown;
    }

    @JsonProperty("turn_upside_down")
    public void setTurnUpsideDown(boolean turnUpsideDown) {
        this.turnUpsideDown = turnUpsideDown;
    }

    @JsonProperty("item")
    public Object getItem() {
        return item;
    }

    @JsonProperty("item")
    public void setItem(Object item) {
        this.item = item;
    }

    @JsonProperty("trigger")
    public Trigger getTrigger() {
        return trigger;
    }

    @JsonProperty("trigger")
    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    @JsonProperty("known_move_type")
    public Object getKnownMoveType() {
        return knownMoveType;
    }

    @JsonProperty("known_move_type")
    public void setKnownMoveType(Object knownMoveType) {
        this.knownMoveType = knownMoveType;
    }

    @JsonProperty("min_affection")
    public Object getMinAffection() {
        return minAffection;
    }

    @JsonProperty("min_affection")
    public void setMinAffection(Object minAffection) {
        this.minAffection = minAffection;
    }

    @JsonProperty("party_type")
    public Object getPartyType() {
        return partyType;
    }

    @JsonProperty("party_type")
    public void setPartyType(Object partyType) {
        this.partyType = partyType;
    }

    @JsonProperty("trade_species")
    public Object getTradeSpecies() {
        return tradeSpecies;
    }

    @JsonProperty("trade_species")
    public void setTradeSpecies(Object tradeSpecies) {
        this.tradeSpecies = tradeSpecies;
    }

    @JsonProperty("party_species")
    public Object getPartySpecies() {
        return partySpecies;
    }

    @JsonProperty("party_species")
    public void setPartySpecies(Object partySpecies) {
        this.partySpecies = partySpecies;
    }

    @JsonProperty("min_happiness")
    public Object getMinHappiness() {
        return minHappiness;
    }

    @JsonProperty("min_happiness")
    public void setMinHappiness(Object minHappiness) {
        this.minHappiness = minHappiness;
    }

    @JsonProperty("held_item")
    public Object getHeldItem() {
        return heldItem;
    }

    @JsonProperty("held_item")
    public void setHeldItem(Object heldItem) {
        this.heldItem = heldItem;
    }

    @JsonProperty("known_move")
    public Object getKnownMove() {
        return knownMove;
    }

    @JsonProperty("known_move")
    public void setKnownMove(Object knownMove) {
        this.knownMove = knownMove;
    }

    @JsonProperty("location")
    public Object getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Object location) {
        this.location = location;
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
