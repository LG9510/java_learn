package com.baeldung.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdderBeforeAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void beforeAdvice()throws Throwable {
        log.info("I would be executed just before method starts");
    }
}
