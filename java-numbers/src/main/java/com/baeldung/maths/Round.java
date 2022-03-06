package com.baeldung.maths;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    private static final double PI = 3.1415d;

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double roundNotPrecise(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        double rounded = Math.round(value * scale) / scale;
        return rounded;
    }
}
