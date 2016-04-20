package card;

public class Card {
    private final String suit;
    private final Rank rank;

    public Card(String suit, Rank rank) {
        this.suit = suit; this.rank = rank;
    }

    public  String getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
}
