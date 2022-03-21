package com.baeldung.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderAfterAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void afterAdvice() throws Throwable {
        log.info("I'm done calling the method");
    }
}
