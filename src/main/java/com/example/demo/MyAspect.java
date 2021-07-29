package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Before("execution(* com.example.demo.AopPrinter.*(..))")
    public void before() {
        System.out.println("I'm before");
    }

    @After("execution(* com.example.demo.AopPrinter.*(..))")
    public void after() {
        System.out.println("I'm after");
    }

    @Around("execution(* com.example.demo.AopPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I'm around before");

        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("Run time: " + time + " ms");

        System.out.println("I'm around after");
        return obj;
    }

}
