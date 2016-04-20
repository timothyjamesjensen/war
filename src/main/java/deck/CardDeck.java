package deck;

import card.Card;
import static card.Rank.*;
import static card.Suit.*;;
import card.Rank;
import card.Suit;

import java.util.ArrayList;

public class CardDeck implements Deck {

    private final Rank[] ranks;
    private final Suit[] suits;
    private ArrayList<Card> cards;
    private int numberOfSuits;
    private int numberOfRanks;

    public CardDeck() {
        ranks = new Rank[]{TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE};
        suits = new Suit[]{HEARTS,DIAMONDS,SPADES,CLUBS};
    }

    public void create(int numberOfSuits, int numberOfRanks) {
        this.numberOfSuits = numberOfSuits;
        this.numberOfRanks = numberOfRanks;
        cards = new ArrayList<>();
        populateDeck(cards);
    }

    public void shuffle() {

    }

    public Card deal() {
        return cards.remove(0);
    }

    // This getter is for testing purposes only
    public ArrayList<Card> getDeck() {
        return cards;
    }

    private void populateDeck(ArrayList cards) {
        // Temporary solution. May need to change this
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
}
