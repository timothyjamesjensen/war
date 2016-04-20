package gametest;

import game.Game;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class GameTest {
    @Test
    public void DealingCardsToPlayersWorks(){
        Game war = new Game();
        war.play(4, 13, 2);
        assertEquals("Players hand size should be 26", 26, war.getPlayers().get(0).getHand().size());
    }

}
