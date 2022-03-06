package com.baeldung.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DoubleToStringTest {
    private static final double DOUBLE_VALUE = 3.56;
    private static final String TRUNCATED_DOUBLE = "3";
    private static final String ROUNDED_UP_DOUBLE = "4";

    @Test
    void truncateByCast() {
        assertThat(DoubleToString.truncateByCast(DOUBLE_VALUE)).isEqualTo(TRUNCATED_DOUBLE);
    }

    @Test
    void roundWithStringFormat() {
        assertThat(DoubleToString.roundWithStringFormat(DOUBLE_VALUE)).isEqualTo(ROUNDED_UP_DOUBLE);
    }

    @Test
    void truncateWithNumberFormat() {
        assertThat(DoubleToString.truncateWithNumberFormat(DOUBLE_VALUE)).isEqualTo(TRUNCATED_DOUBLE);
    }

    @Test
    void truncateWithDecimalFormat() {
        assertThat(DoubleToString.truncateWithDecimalFormat(DOUBLE_VALUE)).isEqualTo(TRUNCATED_DOUBLE);
    }

    @Test
    void roundWithDecimalFormat() {
        assertThat(DoubleToString.roundWithDecimalFormat(DOUBLE_VALUE)).isEqualTo(ROUNDED_UP_DOUBLE);
    }
}