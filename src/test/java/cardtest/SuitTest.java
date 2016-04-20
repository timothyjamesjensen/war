package cardtest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static card.Suit.*;

public class SuitTest {
    @Test
    public void SuitShouldMatchName() {
        assertEquals("HEARTS name should be Hearts", "Hearts", HEARTS.getName());
        assertEquals("DIAMONDS name should be Diamonds", "Diamonds", DIAMONDS.getName());
        assertEquals("SPADES name should be Spades", "Spades", SPADES.getName());
        assertEquals("CLUBS name should be Clubs", "Clubs", CLUBS.getName());
    }
}
