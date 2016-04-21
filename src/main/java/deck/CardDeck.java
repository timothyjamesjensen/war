package deck;

import card.Card;
import static card.Rank.*;
import static card.Suit.*;;
import card.Rank;
import card.Suit;
import java.util.ArrayList;
import java.util.Collections;

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
        Collections.shuffle(cards);
    }

    public Card deal() {
        return cards.remove(0);
    }

    public ArrayList<Card> getDeck() {
        return cards;
    }

    private void populateDeck(ArrayList cards) {
        // Temporary solution. May need to change this
        for (int i=0; i<numberOfSuits; i++) {
            for (int j=0; j<numberOfRanks; j++) {
                cards.add(new Card(suits[i], ranks[j]));
            }
        }
    }
}
