package deck;

import card.Card;
import static card.Rank.*;
import static card.Suit.*;;
import card.Suit;

public class CardDeck implements Deck {

    private int numberOfSuits;
    private int getNumberOfRanks;

    public CardDeck() {

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
