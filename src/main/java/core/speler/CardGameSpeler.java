package core.speler;

import core.model.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SanderP on 18/02/2015.
 */
public class CardGameSpeler extends Speler{
    private List<Card> hand;

    public CardGameSpeler(String naam){
        super(naam);
        this.hand = new ArrayList<>();
    }

    public CardGameSpeler(String naam, List<Card> hand){
        this(naam);
        this.hand.addAll(hand);
    }

    protected void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void voegKaartToeAanHand(Card kaart) {
        this.hand.add(kaart);
    }

    public void maakHandLeeg(){
        this.hand.clear();
    }
}
