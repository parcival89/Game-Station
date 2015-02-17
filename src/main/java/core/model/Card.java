package core.model;

import core.code.CardType;

/**
 *
 * @author SanderP
 * @version 0.0.1
 */
public class Card implements Comparable<Card> {

    private Integer numeral;
    private CardType type;

    public Card() {
    }

    public Card(final CardType type, final int numeral) {
        this.numeral = numeral;
        this.type = type;
    }

    public Integer getNumeral() {
        return numeral;
    }

    public void setNumeral(int numeral) {
        this.numeral = numeral;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Card card) {
        if (this.equals(card)) {
            return 0;
        } else if (this.type.equals(card.getType())) {
            return this.numeral.compareTo(card.numeral);
        } else {
            return this.type.isHigherThan(card.type) ? 1 : -1;
        }
    }

    public boolean equals(Object other) {
        if (other != null && other instanceof Card) {
            Card c = (Card) other;
            if (!c.numeral.equals(this.numeral)) {
                return false;
            }

            if (!c.type.equals(this.type)) {
                return false;
            }

            return true;
        }
        return false;
    }
}
