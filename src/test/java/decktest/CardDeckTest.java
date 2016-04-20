package decktest;

import card.Card;
import card.Rank;
import card.Suit;
import deck.CardDeck;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CardDeckTest {
    @Test
    public void DeckShouldBePopulated() {
        CardDeck cards = new CardDeck();
        cards.create(4, 13);
        for (Card card: cards.getDeck()) {
            assertTrue(card instanceof Card);
            assertTrue(card.getRank() instanceof Rank);
            assertTrue(card.getSuit() instanceof Suit);
        }
    }
}
