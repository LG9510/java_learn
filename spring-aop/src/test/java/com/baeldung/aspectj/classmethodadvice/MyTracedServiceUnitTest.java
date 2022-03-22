package com.baeldung.aspectj.classmethodadvice;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.system.OutputCaptureRule;

public class MyTracedServiceUnitTest {
    @Rule
    public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    @Test
    public void whenPerformingSomeLogic_thenTraceAndInfoOutputIsWritten() {
        MyTracedService myTracedService = new MyTracedService();
        myTracedService.performSomeLogic();

        String output = outputCaptureRule.getOut();
        Assert.assertTrue(output.contains("TracingAspect - Entering MyTracedService.performSomeLogic"));
        Assert.assertTrue(output.contains("MyTracedService - Inside performSomeLogic"));
        Assert.assertTrue(output.contains("TracingAspect - Exiting MyTracedService.performSomeLogic"));
    }

    @Test
    public void whenPerformingSomeAdditionalLogic_thenTraceAndInfoOutputIsWritten() {
        MyTracedService myTracedService = new MyTracedService();
        myTracedService.performSomeAdditionalLogic();

        String output = outputCaptureRule.getOut();
        Assert.assertTrue(output.contains("TracingAspect - Entering MyTracedService.performSomeLogic"));
        Assert.assertTrue(output.contains("MyTracedService - Inside performSomeLogic"));
        Assert.assertTrue(output.contains("TracingAspect - Exiting MyTracedService.performSomeLogic"));
    }
}
