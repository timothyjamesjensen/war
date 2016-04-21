package card;

public enum Suit {
    // I included unicode charaters in the suits, but I couldn't display them because
    // They wouldn't display in all windows consoles.
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
