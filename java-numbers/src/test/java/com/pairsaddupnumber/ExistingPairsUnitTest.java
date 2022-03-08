package com.pairsaddupnumber;

import com.baeldung.pairsaddupnumber.ExistingPairs;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExistingPairsUnitTest {

    final int[] input = {2, 4, 3, 3, 8};
    final int sum = 6;

    @Test
    public void whenTraditionalLoop_thenReturnAllExistingPairs() {
        List<Integer> pairs = ExistingPairs.findPairsWithForLoop(input, sum);

        assertThat(pairs).hasSize(4).contains(2, 4, 3, 3).doesNotContain(8);
    }

    @Test
    public void whenStreamApi_thenReturnAllExistingPairs() {
        List<Integer> pairs = ExistingPairs.findPairsWithStreamApi(input, sum);
        assertThat(pairs).hasSize(4).contains(2, 4, 3, 3).doesNotContain(8);
    }

}
