package player;

import card.Card;
import java.util.ArrayList;

public class Player {
    private final String playerID;
    private ArrayList<Card> hand;

    Player(String playerID) {
        this.playerID = playerID;
        this.hand = new ArrayList<>();
    }
}
