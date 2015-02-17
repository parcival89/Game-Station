package core.code;

import org.junit.Test;

import static core.code.CardType.*;
import static org.assertj.core.api.Assertions.assertThat;


public class CardTypeTest {

    @Test
    public void testGetCodeHarten() throws Exception {
        assertThat(HARTEN.getCode()).isEqualTo(0);
    }

    @Test
    public void testGetCodeKoeken() {
        assertThat(CardType.KOEKEN.getCode()).isEqualTo(1);
    }

    @Test
    public void testGetCodeKlaveren() {
        assertThat(CardType.KLAVEREN.getCode()).isEqualTo(2);
    }

    @Test
    public void testGetCodeSchoppen() {
        assertThat(CardType.SCHOPPEN.getCode()).isEqualTo(3);
    }

    @Test
    public void testIsCardTypeTrue() throws Exception {
        CardType type = HARTEN;

        assertThat(HARTEN.isCardType(type)).isTrue();
    }

    @Test
    public void testIsCardTypeFalse() throws Exception {
        CardType type = HARTEN;

        assertThat(KLAVEREN.isCardType(type)).isFalse();
    }

    @Test
    public void testIsHartenHigherThanKoekenIsTrue() throws Exception {
        CardType type = HARTEN;

        assertThat(type.isHigherThan(KOEKEN)).isTrue();
    }

    @Test
    public void testIsKoekenHigherThanKlaverenIsTrue() throws Exception {
        CardType type = KOEKEN;

        assertThat(type.isHigherThan(KLAVEREN)).isTrue();
    }

    @Test
    public void testIsKlaverennHigherThanSchoppenIsTrue() throws Exception {
        CardType type = KLAVEREN;

        assertThat(type.isHigherThan(SCHOPPEN)).isTrue();
    }

    @Test
    public void testIsSchoppenHigherThanHartenIsFalse() throws Exception {
        CardType type = SCHOPPEN;

        assertThat(type.isHigherThan(HARTEN)).isFalse();
    }

    @Test
    public void testisSchoppenHigherThanSchoppenIsFalse() {
        CardType type = SCHOPPEN;

        assertThat(type.isHigherThan(SCHOPPEN)).isFalse();
    }

    @Test
    public void testFromCodeGivenJuisteCodeThenGeefCardTypeTerug(){
        assertThat(CardType.fromCode(0)).isEqualTo(HARTEN);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testFromCodeGivenInvalidInputThenGooiException(){
        assertThat(CardType.fromCode(-25)).isEqualTo(HARTEN);
    }

    @Test
    public void testGetRandomTypeReturnsInstanceOfCardType() throws Exception {
        CardType randomType = CardType.getRandomType();
        assertThat(randomType).isNotNull();
        assertThat(randomType).isInstanceOf(CardType.class);
    }

    @Test
    public void testGetRandomTypeGeeftVerschillendeCardTypesTerugWhenCalledMultipleTimes(){
        boolean blijfDoorgaan = true;
        CardType type = null;
        int i = 0;
        while(i < 100 && blijfDoorgaan){
            i++;
                CardType randomType = CardType.getRandomType();
            if(type == null) {
                type = randomType;
            }else{
                blijfDoorgaan = type.equals(randomType);
            }
        }

        assertThat(i).isLessThan(100);
    }
}