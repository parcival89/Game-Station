package core.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    @Test
    public void testConstructorWIthNaam(){
        Game game = new GameBuilder().withNaam("Arcadimus").build();

        assertThat(game.getName()).isEqualTo("Arcadimus");
    }

    @Test
    public void testConstructorWIthNull(){
        Game game = new GameBuilder().withNaam(null).build();

        assertThat(game.getName()).isNull();
    }

}