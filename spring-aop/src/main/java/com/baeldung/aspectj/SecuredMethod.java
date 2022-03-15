package com.baeldung.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecuredMethod {
    private static final Logger logger = LoggerFactory.getLogger(SecuredMethod.class);

    @Secured(isLocked = true)
    public void lockedMethod() throws Exception{
        logger.info("lockedMethod");
    }

    @Secured
    public void unlockedMethod() {
        logger.info("unLockedMethod");
    }

    public static void main(String[] args) throws Exception {
        SecuredMethod sv = new SecuredMethod();
        sv.lockedMethod();
    }
}
