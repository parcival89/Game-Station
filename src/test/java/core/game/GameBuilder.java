package core.game;

/**
 * Created by SanderP on 18/02/2015.
 */
public class GameBuilder {

    private String naam;

    public GameBuilder() {
        this.naam = "";
    }

    public static Game aGame() {
        return new GameBuilder().withNaam("The Milk Farm").build();
    }

    public GameBuilder withNaam(String naam) {
        this.naam = naam;
        return this;
    }

    public Game build() {
        return new Game(this.naam) {
            @Override
            public void start() {}

            @Override
            public void stop() {}

            @Override
            public void reset() {}

            @Override
            public String toString() {
                return "Game[naam=" + naam + "]";
            }

            @Override
            public boolean equals(Object o) {
                return (o instanceof Game) && naam.equals(((Game) o).name);
            }

            @Override
            public int hashCode() {
                return naam.hashCode() * 89;
            }
        };
    }
}
