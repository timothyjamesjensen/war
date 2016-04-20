package game;

import card.Card;
import deck.CardDeck;
import deck.Deck;
import player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    // Using a hashmap here for easy deletion of players when they lose. PlayerID is the key
    private HashMap<String, Player> players;
    private ArrayList<Card> cardsOnTable;
    private final boolean winner;

    public Game() {
        players = new HashMap<>();
        cardsOnTable = new ArrayList<>();
        this.winner = false;
    }

    public void play(int numberOfSuits, int numberOfRanks, int playersCount) {
        initPlayers(playersCount);
        Deck cards = new CardDeck();
        cards.create(numberOfSuits, numberOfRanks);
        cards.shuffle();
        dealCardsToPlayers(cards, playersCount);
       // gameLoop();
    }

    public void gameLoop() {
        // this will loop until someone becomes a winner and winner is set to true
        while (!winner) {
            battle();
        }
    }

    public void battle() {
        // all players play cards
        playCards();
        // check for high card
        compareCards(cardsOnTable);
        // build list of players who have high card
        //if list is greater than 1, battle
        //else winner gets all cards
    }

    public void playCards() {
        for (Map.Entry<String, Player> player : players.entrySet()) {
            cardsOnTable.add(player.getValue().playCard());
        }
    }

    public int compareCards(ArrayList<Card> cardsToCompare) {
        int highestValue = 0;
        for (Card card : cardsToCompare) {
            if (card.getRank().getValue() > highestValue) {
                highestValue = card.getRank().getValue();
            }
        }
        return highestValue;
    }

    public void dealCardsToPlayers(Deck cards, int playersCount) {
        // If there are 5 players, each player will get 10 cards and two will be left in the deck
        while (cards.getDeck().size() > 0  && (cards.getDeck().size() - playersCount) >= 0) {
            for (Map.Entry<String, Player> player : players.entrySet()) {
                player.getValue().addCardsToHand(cards.deal());
            }
        }
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    private void initPlayers(int playersCount) {
        for (int i=0; i<playersCount; i++) {
            // NOTE: hashmap key is same as playerID. this makes it easy to delete players
            players.put("player" + i, new Player("player" + i));
        }
    }
}
