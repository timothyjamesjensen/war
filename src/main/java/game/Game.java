package game;

import card.Card;
import deck.CardDeck;
import deck.Deck;
import player.Player;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private ArrayList<Card> cardsOnTable;
    private ArrayList<Card> warCards;
    private ArrayList<Player> highCardHolders;
    private boolean winner;
    private GameCommunicator gc;

    public Game() {
        players = new ArrayList<>();
        cardsOnTable = new ArrayList<>();
        highCardHolders = new ArrayList<>();
        warCards = new ArrayList<>();
        winner = false;
        gc = new GameCommunicator();
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
            //userInput();
            battle(players, highCardHolders, cardsOnTable, warCards);
        }
    }

    public void battle(ArrayList<Player> players, ArrayList<Player> highCardHolders,
                       ArrayList<Card> cardsOnTable, ArrayList<Card> warCards) {

        gc.userInput();
        // All players play a single card
        playCards(players, warCards);
        gc.showCards(players);
        // Check for high card and build list of players who have that card
        buildWinnersList(players, highCardHolders, compareCards(warCards));
        // If multiple card holders exist, go to war
        if (highCardHolders.size() > 1) {
            cardsOnTable.addAll(warCards);
            warCards.clear();
            goToWar(highCardHolders, new ArrayList<Player>(), cardsOnTable, warCards);
            gc.roundWinnerMessage(highCardHolders.get(0), cardsOnTable.size());
        } else {
            // Give all the cards to winner and clear lists
            cardsOnTable.addAll(warCards);
            highCardHolders.get(0).addCardsToHand(cardsOnTable);
            gc.roundWinnerMessage(highCardHolders.get(0), cardsOnTable.size());
        }
        warCards.clear();
        cardsOnTable.clear();
        highCardHolders.clear();

        // Make sure players have at least 1 card, if not they lose
        checkCardCount(1);
        // Every time a player loses, check if there is a winner
        checkForWinner();
    }

    public void goToWar(ArrayList<Player> playersList, ArrayList<Player> highCardHolders,
                        ArrayList<Card> cardsOnTable, ArrayList<Card> warCards) {
        gc.warMessage(playersList);
        // Players need at least 4 cards to go to war
        removePlayersAtWar(checkCardCount(4), playersList);
        //Check for winner after removing players
        if(checkForWinner()) {
            return;
        }
        // War Starts with each player putting 3 cards in the card pool
        for (int i = 0; i<3; i++) {
            playCards(playersList, cardsOnTable);
        }
        // After 3 cards are added to the table, players battle
        battle(playersList, highCardHolders, cardsOnTable, warCards);
    }

    public void playCards(ArrayList<Player> players, ArrayList<Card> cardsOnTable) {
        for (Player player : players) {
            cardsOnTable.add(player.playCard());
        }
    }

    public boolean checkForWinner() {
        if (players.size() == 1) {
            winner = true;
            gc.winnerMessage();
        }
        return winner;
    }

    public ArrayList<String> checkCardCount(int cardsNeededToContinue) {
        ArrayList<String> removeList = new ArrayList<>();
        for (Player player: players) {
            // If players don't have enough cards to continue, they are out of the game
            if (player.getHand().size() < cardsNeededToContinue) {
                gc.loserMessage(player.getPlayerID());
                removeList.add(player.getPlayerID());
            }
        }
        for(String playerId: removeList) {
            removePlayer(playerId, players);
        }
        return removeList;
    }

    public Player removePlayer(String playerID, ArrayList<Player> playersList) {
        for (int i = 0; i < playersList.size(); i++) {
            if (playerID.equals(playersList.get(i).getPlayerID())) {
                return playersList.remove(i);
            }
        }
        return null;
    }

    public void removePlayersAtWar(ArrayList<String> playerIDs, ArrayList<Player> playersList) {
        for (String playerID : playerIDs) {
            removePlayer(playerID, playersList);
            removePlayer(playerID, players);
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

    public void initPlayers(int playersCount) {
        for (int i=0; i<playersCount; i++) {
             players.add(new Player("player" + i));
        }
    }
}
