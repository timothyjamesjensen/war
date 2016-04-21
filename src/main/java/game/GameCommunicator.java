package game;

import player.Player;
import java.util.ArrayList;
import java.util.Scanner;

public class GameCommunicator {
    private Scanner scanner;

    public GameCommunicator() {
        scanner = new Scanner(System.in);
    }

    public boolean keepPlaying() {
        System.out.println("Do you want to keep playing? Press enter!");
        return true;
    }

    public void userInput() {
        System.out.println("Press enter to play the next round!");
        scanner.nextLine();
    }

    public void showCards(ArrayList<Player> playersList) {
        System.out.println("Played Cards\n");
        for (Player player: playersList) {
            System.out.println(player.getPlayerID() + ": " + player.getLastPlayed().show() + "");
        }
        System.out.print("\n");
    }

    public void winnerMessage() {
        System.out.println("We Have a winner!!");
    }

    public void loserMessage(String playerID) {
        System.out.println(playerID + " does not have enough cards to continue. They are" +
                " out of the game and will forfeit all their cards");
    }

    public void warMessage(ArrayList<Player> playerList) {
        for (int i = 0; i<playerList.size(); i++) {
            if (i>0) {
                System.out.print(" and ");
            }
            System.out.print(playerList.get(i).getPlayerID());
        }
        System.out.print(" have the same high card!!");
        System.out.print(" ITS WAR!\n");
    }

    public void roundWinnerMessage(Player winner, int cardsWon) {
        System.out.print(winner.getPlayerID() + " has won the round and gets " + cardsWon + " cards!!\n");
    }
}
