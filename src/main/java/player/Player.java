package player;

import card.Card;
import java.util.ArrayList;

public class Player {
    private final String playerID;
    private ArrayList<Card> hand;
    private Card lastPlayed;

    public Player(String playerID) {
        this.playerID = playerID;
        this.hand = new ArrayList<>();
    }

    public String getPlayerID() {
        return playerID;
    }

    public Card getLastPlayed() {
        return lastPlayed;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardsToHand(Card card) {
        hand.add(card);
    }

    public void addCardsToHand(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard() {
        lastPlayed = hand.remove(0);
        return lastPlayed;
    }
}