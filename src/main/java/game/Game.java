package game;

import card.Card;
import deck.CardDeck;
import deck.Deck;
import player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    // Using a hashmap here for easy deletion of players when they lose. PlayerID is the key
    private ArrayList<Player> players;
    private ArrayList<Card> cardsOnTable;
    private ArrayList<Card> warCards;
    private ArrayList<Player> highCardHolders;
    private boolean winner;

    public Game() {
        players = new ArrayList<>();
        cardsOnTable = new ArrayList<>();
        highCardHolders = new ArrayList<>();
        warCards = new ArrayList<>();
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
        //check if any player has zero cards, if they do, they lose and are kicked from game
        //every time a player loses, check if there is a winner, if there is, return;
        // all players play cards
        playCards();
        // check for high card and build list of players who have that card
        buildWinnersList(compareCards(cardsOnTable));
        // build list of players who have high card
        if (highCardHolders.size() > 1) {
            //goToWar
            //when at war, make sure to check if players have enough cards to war
            //if a player doesn't have enough cards, they lose
        } else {
            // give all the cards to winner and clear lists
            highCardHolders.get(0).addCardsToHand(cardsOnTable);
            cardsOnTable.clear();
            highCardHolders.clear();
        }
    }

    public void playCards() {
        for (Player player : players) {
            cardsOnTable.add(player.playCard());
        }
    }

    public void goToWar(ArrayList<Player> highCardHolders) {
        // War Starts with each player putting down 3 cards
        for (int i = 0; i<3; i++) {
            for (Player player : highCardHolders) {
                cardsOnTable.add(player.playCard());
            }
        }
        for (Player player : highCardHolders) {
            warCards.add(player.playCard());
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

    public void buildWinnersList(int highCard) {
        for (Player player : players) {
            if (player.getLastPlayed().getRank().getValue() == highCard) {
                highCardHolders.add(player);
            }
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

    public ArrayList<Card> getCardsOnTable() {
        return cardsOnTable;
    }

    public ArrayList<Player> getHighCardHolders() {
        return highCardHolders;
    }

    private void initPlayers(int playersCount) {
        for (int i=0; i<playersCount; i++) {
            players.add(new Player("player" + i));
        }
    }
}
