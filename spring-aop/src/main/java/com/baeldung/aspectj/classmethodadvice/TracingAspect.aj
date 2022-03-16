package com.baeldung.aspectj.classmethodadvice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public aspect TracingAspect{
    private static final Log logger = LogFactory.getLog(TracingAspect.class);

    pointcut traceAnnotatedClasses():within(@Trace *) && execution(** (..);

    Object around():traceAnnotatedClasses(){
        String signature = thisJoinPoint.getSignature().toShortString();
        logger.trace("Entering " + signature);
        try{
            return proceed();
        }finally {
            logger.trace("Exiting " + signature);
        }
    }

    after() throwing(Exception e):traceAnnotatedClasses(){
        logger.trace("Exception thrown from " + thisJoinPoint.getSignature().toShortString()
                , e);
    }

}