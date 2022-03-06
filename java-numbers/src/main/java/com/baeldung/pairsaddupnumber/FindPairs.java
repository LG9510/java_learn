package com.baeldung.pairsaddupnumber;

import java.util.ArrayList;
import java.util.List;

public class FindPairs {
    private static void getExistingPairs(int[] input, int sum) {
        List<Integer> pairs = new ArrayList<>();
        System.out.println("~ All existing pairs ~");

        pairs =  ExistingPairs.findPairsWithForLoop(input, sum);
        //Create a pretty printing
        final StringBuilder output1 = new StringBuilder();
        pairs.forEach((pair) -> output1.append("{").append(pair).append(", ").append(sum - pair).append("}, "));
        //print result
        System.out.println("Tradition \"for\" loop: " + output1.toString().substring(0, output1.length() - 1));

        //java 8 stream api
        //call the method
        pairs = ExistingPairs.findPairsWithStreamApi(input, sum);
        //create a pretty printing
        final StringBuilder output2 = new StringBuilder();
        pairs.forEach((pair) -> output2.append("{").append(pair).append(", ").append(sum - pair).append("}, "));
        //print result
        System.out.println("Tradition \"for\" loop: " + output1.toString().substring(0, output1.length() - 1));
    }

    /**
     * Print all different pairs for the given inputs: input array & sum number
     */
    private static void getDifferentPairs(int[] input, int sum) {
        List<Integer> pairs = new ArrayList<>();
        System.out.println("~ All different pairs ~");

        /* Traditional FOR loop */
        // Call method
        pairs = DifferentPairs.findPairsWithForLoop(input, sum);
        // Create a pretty printing
        final StringBuilder output3 = new StringBuilder();
        pairs.forEach((pair) -> output3.append("{" + pair + ", " + (sum - pair) + "}, "));
        // Print result
        System.out.println("Traditional \"for\" loop: " + output3.toString().substring(0, output3.length() - 2));

        /* Java 8 stream API */
        // Call method
        pairs = DifferentPairs.findPairsWithStreamApi(input, sum);
        // Create a pretty printing
        final StringBuilder output4 = new StringBuilder();
        pairs.forEach((pair) -> output4.append("{" + pair + ", " + (sum - pair) + "}, "));
        // Print result
        System.out.println("Java 8 streams API: " + output4.toString().substring(0, output4.length() - 2));
    }
}
