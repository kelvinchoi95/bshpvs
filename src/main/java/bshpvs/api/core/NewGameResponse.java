package bshpvs.api.core;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.awt.Point;

public class NewGameResponse {
    @JsonProperty("userId") public int userId;
    @JsonProperty("userName") public String username;
    @JsonProperty("victoryMessage") public String victoryMessage;
    @JsonProperty("ships") public ShipObject[] ships;

    
    public NewGameResponse(@JsonProperty("userId") int userId, @JsonProperty("userName") String username, @JsonProperty("victoryMessage") String victoryMessage, @JsonProperty("ships")  ShipObject[] ships ) {
        this.userId = userId;
        this.username = username;
        this.victoryMessage = victoryMessage;
        this.ships = ships;
    }

    public static class ShipObject {
        @JsonProperty("identifier") public int identifier;
        @JsonProperty("numSpaces") public int numSpaces;
        @JsonProperty("spaces") public Coordinate[] spaces;

        public ShipObject(@JsonProperty("identifier")  int identifier, @JsonProperty("numSpaces")  int numSpaces, @JsonProperty("spaces") Coordinate[] spaces) {
            this.identifier = identifier;
            this.numSpaces = numSpaces;
            this.spaces = spaces;
        }
    }

    public static class Coordinate {
        @JsonProperty("x") public int x;
        @JsonProperty("y") public int y;
        public Coordinate(@JsonProperty("x") int x, @JsonProperty("y") int y) {
            this.x = x;
            this.y = y;
        }
    }
}