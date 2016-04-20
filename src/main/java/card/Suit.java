package card;

public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String name;
    Suit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
