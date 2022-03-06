package com.baeldung.numberofdigits;


import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Benchmarking {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @State(Scope.Thread)
    public static class ExecutionPlan{
        public int num = Integer.MAX_VALUE;
        public int length = 0;
        public NumberOfDigits numberOfDigits = new NumberOfDigits();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void stringBasedSolution(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.stringBasedSolution(plan.num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void logarithmicApproach(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.logarithmicApproach(plan.num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void repeatedMultiplication(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.repeatedMultiplication(plan.num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void shiftOperators(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.shiftOperators(plan.num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void dividingWithPowersOf2(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.dividingWithPowersOf2(plan.num);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void divideAndConquer(ExecutionPlan plan) {
        plan.length = plan.numberOfDigits.divideAndConquer(plan.num);
    }
}
