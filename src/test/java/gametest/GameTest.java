package gametest;

import card.Card;
import game.Game;
import org.junit.Test;
import java.util.ArrayList;
import static card.Rank.*;
import static card.Suit.HEARTS;
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

    @Test
    public void PlayCardsShouldPopulateCardsOnTable() {
        Game war = new Game();
        war.play(4, 13, 4);
        war.playCards(war.getPlayers(), war.getCardsOnTable());
        assertEquals("Cards on table should equal 4", 4, war.getCardsOnTable().size());
    }

    @Test
    public void CompareCardsShouldFindHighestCard() {
        Game war = new Game();
        war.play(4, 13, 4);
        ArrayList<Card> cardsToCompare = new ArrayList<>();
        cardsToCompare.add(new Card(HEARTS, TWO));
        cardsToCompare.add(new Card(HEARTS, TEN));
        cardsToCompare.add(new Card(HEARTS, ACE));
        assertEquals("Max value should be ACE", ACE.getValue(), war.compareCards(cardsToCompare));
    }
}
