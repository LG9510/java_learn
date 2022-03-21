package com.baeldung.pointcutadvice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = Logger.getLogger(LoggingAspect.class.getSimpleName());

    private ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss:SSS]");
        }
    };

    @Pointcut("within(com.baeldung..*) && execution(* com.baeldung.pointcutadvice.dao.FooDao.*(..))")
    public void repositoryMethods() {

    }

    @Pointcut("within(com.baeldung..*) && execution(* com.baeldung.pointcutadvice.dao.FooDao.*(..))")
    public void loggableMethods() {

    }

    @Pointcut("within(com.baeldung..*) && execution(* com.baeldung.pointcutadvice.annotations.Entity.*(..))")
    public void methodsAcceptingEntities() {

    }

    @Before("repositoryMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info(sdf.get().format(new Date()) + methodName);
    }

    @Before("loggableMethods()")
    public void logMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        log.info("executing method: " + methodName);
    }

    @Before("methodsAcceptingEntities()")
    public void logMethodAcceptionEntityAnnotatedBean(JoinPoint jp) {
        log.info("Accepting beans with @Entity annotation: " + jp.getArgs()[0]);
    }
}
