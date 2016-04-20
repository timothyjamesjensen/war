package cardtest;

import card.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CardTest {
    Card card = new Card("Hearts", "Queen");

    @Test
    public void SuitShouldEqualHearts() {
        assertEquals("Suit must equal 'Hearts'", "Hearts", card.getSuit());
    }

    @Test
    public void RankShouldEqualQueen() {
        assertEquals("Rank must equal 'Queen'", "Queen", card.getRank());
    }
}
