package core.model;

import core.code.CardType;

import java.util.*;

/**
 * @author SanderP
 * @version 0.0.1
 */
public class Deck {
    private Map<CardType, List<Card>> cards;

    public Deck() {
        this.cards = new HashMap<>();
    }

    public Deck(List<CardType> types, Integer cardsPerType) {
        initialize(types, cardsPerType);
    }

    private void initialize(List<CardType> types, Integer cardsPerType) {
        if(types == null){
            throw new IllegalArgumentException("Meegegeven parameter types is null");
        }

        if(cardsPerType == null){
            throw new IllegalArgumentException("Meegegeven paramater cardsPerType is null");
        }

        this.cards = new HashMap<>();

        fillDeck(types, cardsPerType);
    }

    private void fillDeck(List<CardType> types, Integer cardsPerType) {
        types.stream().forEach((type) -> {
            List<Card> typeList = new ArrayList<>();
            for (int i = 0; i < cardsPerType; i++) {
                Card card = new Card(type, i + 1);
                typeList.add(card);
            }
            cards.put(type, typeList);
        });
    }

    public void resetDeck() {
        List<CardType> types = new ArrayList<>();
        types.addAll(cards.keySet());
        initialize(types, cards.values().size());
    }

    public Card drawCard() {
        List<Card> typeList = cards.get(CardType.getRandomType());
        int rand = new Random().nextInt(typeList.size());

        return typeList.remove(rand);
    }

    public int cardsInDeck() {
        return cards.keySet().stream().mapToInt(type -> cards.get(type).size()).sum();
    }

    public boolean isEmpty(){
        return cardsInDeck() >= 0;
    }

    public boolean containsCard(Card card) {
        return this.cards.keySet().stream().anyMatch(type -> cards.get(type).stream().anyMatch(selectedCard -> card.equals(selectedCard)));
    }
}
