package com.bianyuanke.fluxweb;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 马良
 * @since 2019-03-26
 */
@Aspect
@Component
public class ControllerAop {
    @Before("@annotation(com.bianyuanke.fluxweb.Api)")
    public void checkGet(JoinPoint jp) {
        this.check(jp);
    }

    private void check(JoinPoint jp) {
        Object[] args = jp.getArgs();
    }
}
