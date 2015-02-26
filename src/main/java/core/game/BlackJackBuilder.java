package core.game;

public class BlackJackBuilder {
    private String speler;

    public BlackJackBuilder withSpeler(String speler) {
        this.speler = speler;
        return this;
    }

    public static BlackJack aBlackJack() {
        return new BlackJackBuilder().withSpeler("Speler").build();
    }

    public BlackJack build() {
        return new BlackJack(speler);
    }
}