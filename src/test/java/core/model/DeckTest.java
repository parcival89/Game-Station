package core.model;

import core.code.CardType;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static core.code.CardType.HARTEN;
import static core.model.DeckBuilder.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void testEmptyConstructor() {
        Deck deck = DeckBuilder.aDeck();
        assertThat(deck.isEmpty()).isTrue();
    }

    /**
     * constructor w/ args test (happy path)
     */
    @Test
    public void cardsInDeckReturnsTheTotalNumberOfAllCardsInTheDeck() {
        Deck deck = new Deck(Arrays.asList(CardType.values()), 2);
        assertThat(deck.cardsInDeck()).isEqualTo(CardType.values().length * 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestWithTypesNullThenGooiException() {
        Deck deck = new DeckBuilder().withTypes(null).withCardsPerType(25).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorTestWithCardsPerTypeNullThenGooiException() {
        Deck deck = new DeckBuilder()
                .withCardsPerType(null)
                .withType(HARTEN)
                .withType(CardType.KLAVEREN).build();
    }

    @Test
    public void testIsEmptyGeeftTrueTerugWanneerDekLeegIs() throws Exception {
        Deck deck = aDeck();

        assertThat(deck.isEmpty()).isTrue();
    }

    @Test
    public void tesDrawCardWhenThereAreCardsInDeckReturnsACard(){
        Deck deck = aNormalCardDeck();

        Card card = deck.drawCard();
        assertThat(card).isInstanceOf(Card.class);
        assertThat(card).isNotNull();
    }

    @Test
    public void testDrawCardRemovesCardFromDeck() throws Exception {
        Deck deck = aNormalCardDeck();

        assertThat(deck.cardsInDeck()).isEqualTo(52);
        Card card = deck.drawCard();
        assertThat(deck.cardsInDeck()).isEqualTo(51);

        assertThat(deck.containsCard(card)).isFalse();
    }

    @Test
    public void testCardsInDeckGeeft0TerugWanneerDeckLeegIs() throws Exception {
        Deck deck = DeckBuilder.aDeck();

        assertThat(deck.cardsInDeck()).isEqualTo(0);
    }

    @Test
    public void testContainsCardReturnsTrueWhenCardInDeck(){
        Deck deck = aNormalCardDeck();

        assertThat(deck.containsCard(new Card(HARTEN, 1))).isTrue();
    }

    @Test
    public void testContainsCardReturnsFalseWhenCardIsNotInDeck(){
        Deck deck = aNormalCardDeck();

        assertThat(deck.containsCard(new Card(HARTEN, 145))).isFalse();
    }

    @Test
    public void testTrekKaartenGeeftLijstKaartenTerugMetMeegegevenSize(){
        Deck deck = aNormalCardDeck();

        List<Card> kaarten = deck.trekKaarten(7);

        assertThat(kaarten).hasSize(7);
    }

    @Test
    public void testKaartenGeeftLijstZonderDubbelsTerug(){
        Deck deck = aNormalCardDeck();

        List<Card> kaarten = deck.trekKaarten(7);

        assertThat(bevatDubbels(kaarten)).isFalse();
    }

    @Test
    public void resetDeckZorgtVoorEenVolledigAangevuldDeck(){
        Deck deck = aNormalCardDeck();

        deck.trekKaarten(27);
        deck.resetDeck();

        assertThat(deck.cardsInDeck()).isEqualTo(52);
    }

    @Test
    public void resetDeckMaaktBevatOpnieuwAlleKaartenVanHetInitieleDeck(){
        Deck deck = aNormalCardDeck();

        List<Card> initialDeck = deck.trekKaarten(deck.cardsInDeck());

        deck.resetDeck();

        assertThat(deck.containsCards(initialDeck)).isTrue();
    }

    private boolean bevatDubbels(List<Card> kaarten) {
        for(Card card : kaarten){
            if(kaarten.indexOf(card) != kaarten.lastIndexOf(card)) {
                return true;
            }
        }

        return false;
    }
}