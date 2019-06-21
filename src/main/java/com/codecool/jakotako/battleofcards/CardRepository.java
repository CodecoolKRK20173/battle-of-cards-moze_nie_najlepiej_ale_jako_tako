package com.codecool.jakotako.battleofcards;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CardRepository {
    private Iterator<Card> cardIterator;
    private List<Card> cards = new ArrayList<>();


    public CardRepository() {
        cardIterator = new CardIterator();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Iterator<Card> getIterator() {
        return cardIterator;
    }

    private class CardIterator implements Iterator<Card> { //do i have always to Override methods?
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < cards.size();
        }

        @Override
        public Card next() {
            return hasNext() ? cards.get(index++) : null;
        }
    }
}