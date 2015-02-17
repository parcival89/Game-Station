/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.game;

import core.code.CardType;
import core.model.Deck;

import java.util.Arrays;

/**
 * @author SanderP
 */
public class BlackJack extends CardGame {
    private String player;
    private String house;

    private int scorePlayer;
    private int scoreHouse;

    public BlackJack(String player) {
        super("Blackjack", new Deck(Arrays.asList(CardType.values()), 13));
        this.player = player;

        this.scorePlayer = 0;
        this.scoreHouse = 0;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }


}
