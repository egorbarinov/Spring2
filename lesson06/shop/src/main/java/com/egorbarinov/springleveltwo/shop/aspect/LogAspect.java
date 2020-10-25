package com.egorbarinov.springleveltwo.shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LogAspect {

    @Pointcut("execution(* com.egorbarinov.springleveltwo.shop.service..*.*(..))")
    private void anyMethod(){
    }

    @Before("anyMethod()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before ->" + joinPoint);
    }

    @After("anyMethod()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Log after ->" + joinPoint);
    }

    @AfterReturning("anyMethod()")
    public void logReturning(JoinPoint joinPoint){
        System.out.println("Log AfterReturning ->" + joinPoint);
    }

    @AfterThrowing("anyMethod()")
    public void logTrowing(JoinPoint joinPoint){
        System.out.println("Log AfterThrowing ->" + joinPoint);
    }

    @Around("anyMethod()")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        Long timeBefore = System.currentTimeMillis();
        System.out.println("Log Around before -> " + timeBefore);
        Object value = pjp.proceed();
        Long timeAfter = System.currentTimeMillis();
        System.out.println("Log Around after ->" + timeAfter);
        System.out.println("the time of method execution - > " + (timeAfter - timeBefore));
        return value;
    }


}
