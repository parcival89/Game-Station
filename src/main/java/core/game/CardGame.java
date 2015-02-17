package core.game;

import core.model.Deck;

/**
 *
 * @author SanderP
 * @version 0.0.1
 */
public abstract class CardGame extends Game{
    protected Deck deck;
    
    public CardGame(String name, Deck deck) {
        super(name);
        this.deck = deck;
    }
    
    public Deck getDeck(){
        return this.deck;
    }
}
