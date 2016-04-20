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

    @Test
    public void DealEvenAmountOfCardsTo3Players() {
        Game war = new Game();
        war.play(4, 13, 3);
        assertEquals("Players hand size should be 17",17, war.getPlayers().get(0).getHand().size());
    }

    @Test
    public void DealEvenAmountOfCardsTo5Players() {
        Game war = new Game();
        war.play(4, 13, 5);
        assertEquals("Players hand size should be 10",10, war.getPlayers().get(0).getHand().size());
    }
}
