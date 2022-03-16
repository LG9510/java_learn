package com.baeldung.joinpoint;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class JoinPointAroundCacheAspect {
    public final static Map<Object, Object> CACHE = new HashMap<>();

    @Pointcut("execution(* com.baeldung.joinpoint.ArticleService.getArticleList(..))")
    public void articleListPointcut() {

    }

    @Around("artcleListPointcut()")
    public Object aroundAdviceCache(ProceedingJoinPoint pjp) throws Throwable {
        Object article = CACHE.get(pjp.getArgs());
        if (article == null) {
            article = pjp.proceed(pjp.getArgs());
            CACHE.put(pjp.getArgs(), article);
        }
        return article;
    }

}
