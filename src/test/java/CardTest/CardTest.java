package cardtest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import card.*;
import static card.Rank.*;
import static card.Suit.*;

public class CardTest {
    Card card = new Card(HEARTS, QUEEN);

    @Test
    public void SuitShouldEqualHearts() {
        assertEquals("Suit must equal 'Hearts'", HEARTS, card.getSuit());
    }

    @Test
    public void RankShouldEqualQueen() {
        assertEquals("Rank must equal 'Queen'", QUEEN, card.getRank());
    }
}
