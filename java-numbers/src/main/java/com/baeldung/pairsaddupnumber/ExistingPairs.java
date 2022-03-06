package com.baeldung.pairsaddupnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ExistingPairs {
    public static List<Integer> findPairsWithForLoop(int[] input, int sum) {
        final List<Integer> allExistingPairs = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (j != i && (input[i] + input[j] == sum)) {
                    allExistingPairs.add(input[i]);
                }
            }
        }
        return allExistingPairs;
    }

    public static List<Integer> findPairsWithStreamApi(int[] input, int sum) {
        final List<Integer> allExistingPairs = new ArrayList<>();
        IntStream.range(0, input.length).forEach(i ->
                IntStream.range(0, input.length)
                        .filter(j -> i != j && input[i] + input[j] == sum)
                        .forEach(j -> allExistingPairs.add(input[i])));
        return allExistingPairs;
    }
}
