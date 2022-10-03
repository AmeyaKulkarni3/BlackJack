package com.ameya.model;

import com.ameya.utils.CardValueMap;
import com.ameya.utils.Rank;
import com.ameya.utils.Suit;

import java.util.Comparator;
import java.util.Map;

public class Card implements Comparator<Card> {

    private Rank rank;
    private Suit suit;
    private int value;

    private final Map<Rank,Integer> values;

    public Card() {
        values = CardValueMap.getValues();
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getValue() {
        return values.get(this.rank);
    }

    public void setValue() {
        this.value =  values.get(this.rank);
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

    @Override
    public int compare(Card o1, Card o2) {
        int suitCompare = o1.suit.toString().compareTo(o2.suit.toString());
        int valueCompare = o1.value - o2.value;
        return (suitCompare == 0) ? valueCompare : suitCompare;
    }
}
