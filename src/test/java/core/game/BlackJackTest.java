package core.game;

import org.junit.Test;

import static core.game.BlackJackBuilder.aBlackJack;
import static org.assertj.core.api.Assertions.assertThat;


public class BlackJackTest {

    public static final String HOUSE = "House";

    @Test
    public void whenConstructorGivenSpelerNaamThenMaakNiewSpelMetSpelerEnHouse(){
        BlackJack bj = new BlackJackBuilder().withSpeler("Olifanter").build();

        assertThat(bj.getSpeler()).isNotNull();
        assertThat(bj.getSpeler().getNaam()).isEqualTo("Olifanter");
        assertThat(bj.getHouse()).isNotNull();
        assertThat(bj.getHouse().getNaam()).isEqualTo(HOUSE);
    }

    @Test(expected=IllegalArgumentException.class)
    public void whenConstructorGivenNullThenThrowException(){
        new BlackJackBuilder().withSpeler(null).build();
    }

    @Test
    public void testStartGeeftElkeSpeler2kaarten() throws Exception {
        BlackJack bj = aBlackJack();

        bj.start();

        assertThat(bj.getSpeler().getHand()).hasSize(2);
        assertThat(bj.getHouse().getHand()).hasSize(2);
    }

    @Test
    public void testStartZetALleScoresOp0(){
        BlackJack bj = aBlackJack();

        bj.start();

        assertThat(bj.getScoreHouse()).isEqualTo(0);
        assertThat(bj.getScorePlayer()).isEqualTo(0);
    }


    @Test
    public void testStartZetStatusOpRUNNING(){
        BlackJack bj = aBlackJack();

        bj.start();

        assertThat(bj.getStatus()).isEqualTo(Status.RUNNING);
    }

    @Test
    public void testStop() throws Exception {

    }

    @Test
    public void testResetVerwijdertAlleKaartenUitElkeSpelerZijnHand() throws Exception {
        BlackJack bj = aBlackJack();

        bj.start();
        bj.reset();

        assertThat(bj.getSpeler().getHand().isEmpty()).isTrue();
        assertThat(bj.getHouse().getHand().isEmpty()).isTrue();
    }

    @Test
    public void testResetMaaktHetDeckWeerVolledig(){
        BlackJack bj = aBlackJack();

        bj.start();
        bj.reset();

        assertThat(bj.getDeck().cardsInDeck()).isEqualTo(52);
    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {

    }

    @Test
    public void testHashCode() throws Exception {

    }
}