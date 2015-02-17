package core.model;


import core.code.CardType;
import org.assertj.core.api.Assert;
import org.junit.Test;

import core.model.Card;

import static core.code.CardType.HARTEN;
import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @Test
    public void givenEmptyCardConstructor_ThenNewCardIsCreated_WithNoSpecificPropteries(){
        Card card = new Card();

        assertThat(card.getType()).isNull();
        assertThat(card.getNumeral()).isNull();
    }

    @Test
    public void givenCardConstructor_WithCardTypeAndOrdinal_ThenNewCardIsCreated(){
        Card card = new Card(HARTEN, 1);

        assertThat(card.getNumeral()).isEqualTo(1);
        assertThat(card.getType()).isEqualTo(HARTEN);
    }

}