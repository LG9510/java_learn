package com.removingdecimals;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Measurement(iterations = 20)
@OutputTimeUnit(TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class RemovingDecimalsManualTest {
    @Param(value = {"345.56", "345345345.56", "345345345345345345.56"})
    double doubleValue;

    NumberFormat nf;
    DecimalFormat df;

    @Setup
    public void readyFormatters() {
        nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        df = new DecimalFormat("#.###");
    }

    @Benchmark
    public String whenCastToInt_thenValueIsTruncated() {
        return String.valueOf((int) doubleValue);
    }

    @Benchmark
    public String whenUsingStringFormat_thenValueIsRounded() {
        return String.format("%.0f", doubleValue);
    }

    @Benchmark
    public String whenUsingNumberFormat_thenValueIsRounded() {
        nf.setRoundingMode(RoundingMode.HALF_UP);
        return nf.format(doubleValue);
    }

    @Benchmark
    public String whenUsingNumberFormatWithFloor_thenValueIsTruncated() {
        nf.setRoundingMode(RoundingMode.FLOOR);
        return nf.format(doubleValue);
    }

    @Benchmark
    public String whenUsingDecimalFormat_thenValueIsRounded() {
        nf.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(doubleValue);
    }

    @Benchmark
    public String whenUsingDecimalFormatWithFloor_thenValueIsTruncated() {
        df.setRoundingMode(RoundingMode.FLOOR);
        return df.format(doubleValue);
    }

    @Benchmark
    public String whenUsingBigDecimalDoubleValue_thenValueIsTruncated() {
        BigDecimal big = new BigDecimal(doubleValue);
        big = big.setScale(0, RoundingMode.FLOOR);
        return big.toString();
    }

    @Benchmark
    public String whenUsingBigDecimalDoubleValueWithHalfUp_thenValueIsRounded() {
        BigDecimal big = new BigDecimal(doubleValue);
        big = big.setScale(0, RoundingMode.HALF_UP);
        return big.toString();
    }


    @Test
    public void runBenchMarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getSimpleName()).threads(1)
                .forks(1).shouldFailOnError(true).shouldDoGC(true)
                .jvmArgs("-server").build();
        new Runner(options).run();
    }






















}
