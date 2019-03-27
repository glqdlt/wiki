package com.glqdlt.tool.wiki;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author glqdlt
 * 2019-03-27
 */
@Slf4j
@Aspect
@Component
public class AuditAspect {
    @Before("@annotation(Audit))")
    public void logging(JoinPoint joinpoint){
        Object[] args = joinpoint.getArgs();
        Signature signature = joinpoint.getSignature();
        log.info("method name : {}",signature.getName()+"(...)");
        int c = 1;
        for(Object a : args){
            log.info("[{}]arg value: {}",c,a.toString());
            c++;
        }
    }
}
