import game.Game;
import java.util.Scanner;
import java.util.InputMismatchException;

public class War {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
    }

    public static void play( int numberOfSuits, int numberOfRanks, int numberOfPlayers ){
        System.out.println("Alright! Its a " + numberOfPlayers + " player game of War with a " +
                (numberOfRanks * numberOfSuits) + " card deck!\n\n");

        Game war = new Game();
        war.play(numberOfSuits, numberOfRanks, numberOfPlayers);
    }

    public static void welcome() {
        System.out.println("Welcome to the card game War!\n");
        System.out.println("Main Menu\n\nNew Game:  Any Letter+ENTER\nQuit:      q+ENTER");
        String input = scanner.next();

        if (input.equals("q")) {
            System.out.println("\n\nThanks for playing!");
        } else {
            System.out.println("\nHey! I'm glad you decided to play a game!!" +
                    "I need a little bit of input from you and then" +
                    " we can get started!\n");

            play(getValidIntegerInput(2,4,"number of card suits"), getValidIntegerInput(6,13,"number or card ranks"),
                    getValidIntegerInput(2,5,"Player Count"));
        }
    }

    public static int getValidIntegerInput(int floor, int ceiling, String inputName) {
        int input = 0;
        while (input < floor || input > ceiling) {
            try {
                System.out.print("Enter a " + inputName + " between " + floor + " and " + ceiling + ": ");
                input = scanner.nextInt();
                if (input < floor || input > ceiling) {
                    System.out.println("\nHey! I thought I said to enter a number between 2 and 5!\nTry again!");
                    //scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("\nHey! I thought I said to enter a NUMBER between 2 and 5!\nTry again!");
                scanner.next();
            }
        }
        return input;
    }
}
