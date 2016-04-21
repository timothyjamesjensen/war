package gametest;

import game.GameCommunicator;
import org.junit.Test;
import player.Player;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class GameCommunicatorTest {
    @Test
    public void WarMessageDisplaysCorrectly() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("player1"));
        players.add(new Player("player2"));
        GameCommunicator gc = new GameCommunicator();
        gc.warMessage(players);
        assertEquals("player1 and player2 have the same high card!! ITS WAR!\n", outContent.toString());
    }

    @Test
    public void RoundWinnerMessageDisplaysCorrectly() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        GameCommunicator gc = new GameCommunicator();
        Player winner = new Player("player1");
        gc.roundWinnerMessage(winner, 5);
        assertEquals("player1 has won the round and gets 5 cards!!\n", outContent.toString());
    }
}
