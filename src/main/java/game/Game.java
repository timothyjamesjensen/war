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
        gameLoop();
    }

    public void gameLoop() {
        // This will loop until someone becomes a winner and winner is set to true
        while (!winner) {
            battle(players, highCardHolders, cardsOnTable, warCards);
        }
    }

    public void battle(ArrayList<Player> players, ArrayList<Player> highCardHolders,
                       ArrayList<Card> cardsOnTable, ArrayList<Card> warCards) {
        // Make sure players have at least 1 card, if not they lose
        checkCardCount(1);
        //every time a player loses, check if there is a winner, if there is, return;
        if (weHaveAWinner()) {
            return;
        }
        // All players play a single card
        playCards(players, warCards);
        // Check for high card and build list of players who have that card
        buildWinnersList(players, highCardHolders, compareCards(cardsOnTable));
        // If multiple card holders exist, go to war
        if (highCardHolders.size() > 1) {
            cardsOnTable.addAll(warCards);
            warCards.clear();
            goToWar(highCardHolders, new ArrayList<Player>(), cardsOnTable, warCards);

        } else {
            // Give all the cards to winner and clear lists
            cardsOnTable.addAll(warCards);
            highCardHolders.get(0).addCardsToHand(cardsOnTable);
            warCards.clear();
            cardsOnTable.clear();
            highCardHolders.clear();
        }
    }

    public void goToWar(ArrayList<Player> players, ArrayList<Player> highCardHolders,
                        ArrayList<Card> cardsOnTable, ArrayList<Card> warCards) {
        // Players need at least 4 cards to go to war
        checkCardCount(4);
        // War Starts with each player putting 3 cards in the card pool
        for (int i = 0; i<3; i++) {
            playCards(players, cardsOnTable);
        }
        // After 3 cards are added to the table, players battle
        battle(players, highCardHolders, cardsOnTable, warCards);
    }

    public void playCards(ArrayList<Player> players, ArrayList<Card> cardsOnTable) {
        for (Player player : players) {
            cardsOnTable.add(player.playCard());
        }
    }

    public boolean weHaveAWinner() {
        if (players.size() == 1) {
            winner = true;
            System.out.println("We have a winner!!");
        }
        return winner;
    }

    public void checkCardCount(int cardsNeededToContinue) {
        for (Player player: players) {
            // If players don't have enough cards to continue, they are out of the game
            if (player.getHand().size() < cardsNeededToContinue) {
                System.err.println(player.playCard() + " does not have enough cards to continue. They are" +
                        " out of the game and will forfeit all their cards");
            }
        }
    }

    public Player removePlayer(String playerID, ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            if (playerID.equals(players.get(i).getPlayerID())) {
                return players.remove(i);
            }
        }
        return null;
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

    public void buildWinnersList(ArrayList<Player> players, ArrayList<Player> winners, int highCard) {
        for (Player player : players) {
            if (player.getLastPlayed().getRank().getValue() == highCard) {
                winners.add(player);
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

    private void initPlayers(int playersCount) {
        for (int i=0; i<playersCount; i++) {
            players.add(new Player("player" + i));
        }
    }
}
