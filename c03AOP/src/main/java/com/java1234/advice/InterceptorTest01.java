package com.java1234.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class InterceptorTest01 {

    @Before("execution(* com.java1234.service..*.*(..))")
    public void doBefore() {
        System.out.println("do some important things before...");
    }
}