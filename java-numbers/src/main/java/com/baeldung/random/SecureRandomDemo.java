package com.baeldung.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SecureRandomDemo {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        int randomInt = sr.nextInt();
        long randomLong = sr.nextLong();
        float randomFloat = sr.nextFloat();
        double randomDouble = sr.nextDouble();

        IntStream randomIntStream = sr.ints();
        LongStream randomLongStream = sr.longs();
        DoubleStream randomDoubleStream = sr.doubles();

        byte[] values = new byte[124];
        sr.nextBytes(values);

    }

    public static SecureRandom getSecureRandomForAlgorithm(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null || algorithm.isEmpty()) {
            return new SecureRandom();
        }
        return SecureRandom.getInstance(algorithm);
    }
}
