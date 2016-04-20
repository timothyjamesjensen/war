package game;

import deck.CardDeck;
import deck.Deck;
import player.Player;
import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;

    public Game() {
        players = new ArrayList<>();
    }

    public void play(int numberOfSuits, int numberOfRanks, int playersCount) {
        initPlayers(playersCount);
        Deck cards = new CardDeck();
        cards.create(numberOfSuits, numberOfRanks);
        cards.shuffle();
        dealCardsToPlayers(cards, playersCount);
    }

    public void dealCardsToPlayers(Deck cards, int playersCount) {
        while (cards.getDeck().size() > 0) {
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
