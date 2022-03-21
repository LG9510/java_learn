package com.baeldung.logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AdderAroundAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public Object aroundAdvice(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Argument passed to method are " + Arrays.toString(joinPoint.getArgs()));
        final Object result = joinPoint.proceed();
        log.info("Result from method is :" + result);
        return result;
    }
}
