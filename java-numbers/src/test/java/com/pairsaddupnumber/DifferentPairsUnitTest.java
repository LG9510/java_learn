package com.pairsaddupnumber;

import com.baeldung.pairsaddupnumber.DifferentPairs;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DifferentPairsUnitTest {
    final static int[] input = {2, 4, 3, 3, 8};
    final static int sum = 6;
    @Test
    public void whenTraditionalLoop_thenReturnAllDifferentPairs() {

        List<Integer> pairs = DifferentPairs.findPairsWithForLoop(input, sum);
        assertThat(pairs).hasSize(2).contains(4, 3).doesNotContain(8);
    }

    @Test
    public void whenStreamApi_thenReturnAllDifferentPairs() {
        List<Integer> pairs = DifferentPairs.findPairsWithStreamApi(input, sum);
        assertNotNull(pairs);
        assertEquals(pairs.size(), 2);
        assertEquals(pairs.get(0), new Integer(4));
        assertThat(pairs).hasSize(2).contains(4, 3).doesNotContain(8);
    }
}
