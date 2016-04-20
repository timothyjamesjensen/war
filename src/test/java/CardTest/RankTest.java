package cardtest;

import card.Rank;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RankTest {
    @Test
    public void ThereShouldBe13Ranks() {
        assertEquals("Ranks length should equal 13", 13, Rank.values().length);
    }
}
