package core.speler;

/**
 * Created by SanderP on 18/02/2015.
 */
public class BlackJackSpeler extends CardGameSpeler{
    private int score;

    public BlackJackSpeler(String naam) {
        super(naam);
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public int[] berekenHand(){
        throw new UnsupportedOperationException();
    }
}
