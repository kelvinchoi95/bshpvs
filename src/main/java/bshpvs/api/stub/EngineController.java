package bshpvs.api.stub;

import bshpvs.api.core.NewGameRequest;
import bshpvs.engine.Game;
import bshpvs.model.Player;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin
@Controller
public class EngineController {


    public Player playerOne;
    public Player playerTwo;
    public Game game;

    @CrossOrigin
    @MessageMapping("/placeShips")
    @SendTo("/topic/getUserShips")
    public NewGameRequest greeting(String json) throws Exception {
        Thread.sleep(1000); // simulated delay
        ObjectMapper objectMapper = new ObjectMapper();
        NewGameRequest req = objectMapper.readValue(json, NewGameRequest.class);
        
        System.out.println(req.toString());
        //return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        return null;
    }


    public void initializePlayers() {
        this.playerOne = new Player(10);
        this.playerTwo = new Player(10);
    }

    public void initializeGame() {
        game = new Game(this.playerOne, this.playerTwo);
    }
}
