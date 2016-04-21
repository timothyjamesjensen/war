package decktest;

import card.Card;
import card.Rank;
import card.Suit;
import deck.CardDeck;
import deck.Deck;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardDeckTest {
    @Test
    public void DeckShouldBePopulated() {
        CardDeck cards = new CardDeck();
        cards.create(4, 13);
        for (Card card: cards.getDeck()) {
            assertTrue(card instanceof Card
                && card.getRank() instanceof Rank
                && card.getSuit() instanceof Suit);
        }
    }

    @Test
    public void DealShouldReturnCard() {
        Deck cards = new CardDeck();
        cards.create(4,13);
        // create single card that can be used for each assert
        Card newCard = cards.deal();
        assertTrue(newCard instanceof Card
                && newCard.getRank() instanceof Rank
                && newCard.getSuit() instanceof Suit);
    }

    @Test
    public void DealShouldReduceDeckSizeByOne() {
        CardDeck cards = new CardDeck();
        cards.create(4,13);
        int originalDeckSize = cards.getDeck().size();
        cards.deal();
        assertEquals("Deck size should be one less than originalDeckSize",
                originalDeckSize-1, cards.getDeck().size());
    }

    @Test
    public void DeckShouldHave30Cards() {
        CardDeck cards = new CardDeck();
        cards.create(3,10);
        assertEquals("Deck should have a size of 30", 30, cards.getDeck().size());
    }
}
