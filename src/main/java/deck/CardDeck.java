package deck;

import card.Card;
import static card.Rank.*;
import static card.Suit.*;;
import card.Rank;
import card.Suit;

public class CardDeck implements Deck {

    private int numberOfSuits;
    private int getNumberOfRanks;
    private final Rank[] ranks;
    private final Suit[] suits;

    public CardDeck() {
        ranks = new Rank[]{TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE};
        suits = new Suit[]{HEARTS,DIAMONDS,SPADES,CLUBS};
    }

    public void create(int numberOfSuits, int numberOfRanks) {
        this.numberOfSuits = numberOfSuits;
        this.getNumberOfRanks = numberOfRanks;
    }

    public void shuffle() {

    }

    public Card deal() {
        return new Card(HEARTS, ACE);
    }
}
