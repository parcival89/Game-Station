package core.model;

import core.code.CardType;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SanderP on 17/02/2015.
 */
public class DeckBuilder {

    private List<CardType> types = new ArrayList<>();
    private Integer cardsPerType = 0;

    public DeckBuilder(){
        resetFields();
    }

    public static Deck aDeck() {
        return new DeckBuilder().build();
    }

    public static Deck aNormalCardDeck(){
        return new DeckBuilder().withCardsPerType(13).withTypes(Lists.newArrayList(CardType.values())).build();
    }

    private void resetFields() {
        this.types = new ArrayList<>();
        this.cardsPerType = 0;
    }

    public Deck build(){
        return new Deck(types, cardsPerType);
    }

    public DeckBuilder withType(CardType type){
        types.add(type);
        return this;
    }

    public DeckBuilder withTypes(List<CardType> types) {
        this.types = types;
        return this;
    }

    public DeckBuilder withCardsPerType(Integer cardsPerType){
        this.cardsPerType = cardsPerType;
        return this;
    }
}
