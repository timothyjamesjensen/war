package card;

public enum Suit {
    HEARTS("Hearts", "\u2665"),
    SPADES("Spades", "\u2660"),
    DIAMONDS("Diamonds", "\u2666"),
    CLUBS("Clubs", "\u2663");

    private final String name;
    private final String icon;
    Suit(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
