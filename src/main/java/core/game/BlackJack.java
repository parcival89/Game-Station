/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.game;

import core.code.CardType;
import core.model.Deck;
import core.speler.BlackJackSpeler;

import java.util.Arrays;

/**
 * @author SanderP
 */
public class BlackJack extends CardGame {
    private BlackJackSpeler speler;
    private BlackJackSpeler house;

    private int scorePlayer;
    private int scoreHouse;

    public BlackJack(String speler) {
        super("Blackjack", new Deck(Arrays.asList(CardType.values()), 13));

        if(speler == null){
            throw new IllegalArgumentException("Spelernaam kan niet null zijn");
        }

        this.speler = new BlackJackSpeler(speler);
        this.house = new BlackJackSpeler("House");

        this.scorePlayer = 0;
        this.scoreHouse = 0;
    }

    public BlackJackSpeler getSpeler() {
        return speler;
    }

    public BlackJackSpeler getHouse() {
        return house;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public int getScoreHouse() {
        return scoreHouse;
    }

    @Override
    public void start() {
        deck.trekKaarten(2).forEach(kaart -> speler.voegKaartToeAanHand(kaart));
        deck.trekKaarten(2).forEach(kaart -> house.voegKaartToeAanHand(kaart));

        status = Status.RUNNING;
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        speler.maakHandLeeg();
        house.maakHandLeeg();

        deck.resetDeck();
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
