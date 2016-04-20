package game;

import deck.CardDeck;
import deck.Deck;
import player.Player;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private final boolean winner;

    public Game() {
        players = new ArrayList<>();
        this.winner = false;
    }

    public void play(int numberOfSuits, int numberOfRanks, int playersCount) {
        initPlayers(playersCount);
        Deck cards = new CardDeck();
        cards.create(numberOfSuits, numberOfRanks);
        cards.shuffle();
        dealCardsToPlayers(cards, playersCount);
        gameLoop();
    }

    public void gameLoop() {
        // this will loop until someone becomes a winner and winner is set to true
        while (!winner) {

        }
    }

    public void dealCardsToPlayers(Deck cards, int playersCount) {
        // If there are 5 players, each player will get 10 cards and two will be left in the deck
        while (cards.getDeck().size() > 0  && (cards.getDeck().size() - playersCount) >= 0) {
            for (Player player : players) {
                player.addCardsToHand(cards.deal());
            }
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private void initPlayers(int playersCount) {
        for (int i=0; i<playersCount; i++) {
            players.add(new Player("player" + i));
        }
    }
}
