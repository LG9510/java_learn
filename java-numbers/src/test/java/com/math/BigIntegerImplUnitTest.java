package com.math;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class BigIntegerImplUnitTest {
    @Test
    public void givenBigIntegerNumbers_whenAddedTogether_thenGetExpectedResult() {
        BigInteger numStarsMilkyWay = new BigInteger("8731409320171337804361260816606476");
        BigInteger numStarsAndromeda = new BigInteger("5379309320171337804361260816606476");

        BigInteger totalStars = numStarsAndromeda.add(numStarsMilkyWay);
        BigInteger result = new BigInteger("14110718640342675608722521633212952");

        Assert.assertEquals(result,totalStars);
    }
}
