package com.ameya.utils;

import java.util.HashMap;
import java.util.Map;

public class CardValueMap {

    private static Map<Rank,Integer> values = new HashMap<>();

    static {
        values.put(Rank.ACE,1);
        values.put(Rank.TWO,2);
        values.put(Rank.THREE,3);
        values.put(Rank.FOUR,4);
        values.put(Rank.FIVE,5);
        values.put(Rank.SIX,6);
        values.put(Rank.SEVEN,7);
        values.put(Rank.EIGHT,8);
        values.put(Rank.NINE,9);
        values.put(Rank.TEN,10);
        values.put(Rank.JACK,10);
        values.put(Rank.QUEEN,10);
        values.put(Rank.KING,10);
        values.put(Rank.ACE_ELEVEN,11);

    }

    public static void setValues(Map<Rank, Integer> values) {
        CardValueMap.values = values;
    }

    public static Map<Rank, Integer> getValues() {
        return values;
    }
}
