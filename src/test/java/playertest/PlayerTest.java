package playertest;

import card.Card;

import org.junit.Test;
import player.Player;

import java.util.ArrayList;

import static card.Rank.*;
import static card.Suit.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void GetPlayerIDShouldReturnCorrectValue() {
        Player player1 = new Player("player1");
        assertEquals("PlayerID should equal player1", "player1", player1.getPlayerID());
    }

    @Test
    public void GetPlayerHandShouldReturnThePlayersHand() {
        Player player1 = new Player("player1");
        Card newCard = new Card(SPADES, ACE);
        player1.addCardsToHand(newCard);
        assertEquals("Size of players hand should equal 1", 1, player1.getHand().size());
    }

    @Test
    public void AddingMultipleCardsToHandShouldWork() {
        Player player1 = new Player("player1");
        Card newCard1 = new Card(SPADES, TWO);
        Card newCard2 = new Card(SPADES, THREE);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(newCard1);
        cards.add(newCard2);
        player1.addCardsToHand(cards);
        assertEquals("size of players hand should equal 2", 2, player1.getHand().size());
    }

    @Test
    public void AddingSingleCardsToHandShouldWork() {
        Player player1 = new Player("player1");
        Card newCard1 = new Card(SPADES, TWO);
        Card newCard2 = new Card(SPADES, THREE);
        player1.addCardsToHand(newCard1);
        player1.addCardsToHand(newCard2);
        assertEquals("Hand size should equal 2", 2, player1.getHand().size());
    }

    @Test
    public void PlayCardShouldReturnTopCardInPlayersHand() {
        Player player1 = new Player("player1");
        Card newCard1 = new Card(SPADES, TWO);
        Card newCard2 = new Card(SPADES, THREE);
        player1.addCardsToHand(newCard1);
        player1.addCardsToHand(newCard2);
        assertEquals("Card Rank should equal 2", 2, player1.playCard().getRank().getValue());
    }

    @Test
    public void PlayCardShouldDecreaseSizeOfHandByOne() {
        Player player1 = new Player("player1");
        Card newCard1 = new Card(SPADES, TWO);
        Card newCard2 = new Card(SPADES, THREE);
        player1.addCardsToHand(newCard1);
        player1.addCardsToHand(newCard2);
        player1.playCard();
        assertEquals("Hand Size should equal 1", 1, player1.getHand().size());
    }
}
