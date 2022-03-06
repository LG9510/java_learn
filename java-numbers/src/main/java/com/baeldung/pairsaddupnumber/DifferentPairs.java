package com.baeldung.pairsaddupnumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class DifferentPairs {
    public static List<Integer> findPairsWithForLoop(int[] input, int sum) {
        ArrayList<Integer> allDifferentPairs = new ArrayList<>();
        HashMap<Integer, Integer> pairs = new HashMap<>();
        for (int i : input) {
            if (pairs.containsKey(i)) {
                if (pairs.get(i) != null) {
                    allDifferentPairs.add(i);
                }
                pairs.put(sum - i, null);
            } else if (!pairs.containsValue(i)) {
                pairs.put(sum - i, i);
            }
        }
        return allDifferentPairs;
    }

    public static List<Integer> findPairsWithStreamApi(int[] input, int sum) {
        final List<Integer> allDifferentPairs = new ArrayList<>();
        final Map<Integer, Integer> pairs = new HashMap<>();
        IntStream.range(0,input.length).forEach(i->{
            if (pairs.containsKey(input[i])) {
                if (pairs.get(input[i]) != null) {
                    allDifferentPairs.add(input[i]);
                }
                pairs.put(sum - input[i], null);
            } else if (!pairs.containsValue(input[i])) {
                pairs.put(sum - input[i], input[i]);
            }
        });
        return allDifferentPairs;
    }
}
