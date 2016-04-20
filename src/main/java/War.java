import java.util.Scanner;
import java.util.InputMismatchException;

public class War {

    public static void main(String[] args) {
        welcome();
    }

    public static void play( int numberOfSuits, int numberOfRanks, int numberOfPlayers ){
        System.out.println("Alright! Its a " + numberOfPlayers + " player game of War!\n\n");
    }

    public static void welcome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the card game War!\n");
        System.out.println("Main Menu\n\nNew Game:  Any Letter+ENTER\nQuit:      q+ENTER");

        String input = scanner.next();

        if (input.equals("q")) {
            System.out.println("\n\nThanks for playing!");
        } else {
            System.out.println("\nHey! I'm glad you decided to play a game!!" +
                    "I need you to enter how many players there will be and then" +
                    " we can get started!\n");

            int playerCount = 0;
            while (playerCount < 2 || playerCount > 5) {
                try {
                    System.out.print("Enter a Player count between 2 and 5: ");
                    playerCount = scanner.nextInt();
                    if (playerCount < 2 || playerCount > 5) {
                        System.err.println("\nHey! I thought I said to enter a number between 2 and 5!\nTry again!");
                        //scanner.next();
                    }
                } catch (InputMismatchException e) {
                    System.err.println("\nHey! I thought I said to enter a NUMBER between 2 and 5!\nTry again!");
                    scanner.next();
                }
            }
            play(4, 13, playerCount);
        }
    }
}
