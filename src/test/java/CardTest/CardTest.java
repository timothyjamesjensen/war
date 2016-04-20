package cardtest;

import card.*;
import static card.Rank.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CardTest {
    Card card = new Card("Hearts", QUEEN);

    @Test
    public void SuitShouldEqualHearts() {
        assertEquals("Suit must equal 'Hearts'", "Hearts", card.getSuit());
    }

    @Test
    public void RankShouldEqualQueen() {
        assertEquals("Rank must equal 'Queen'", QUEEN, card.getRank());
    }
}
