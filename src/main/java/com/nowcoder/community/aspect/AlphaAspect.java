package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {

    // 切点：返回值 包 类 方法 参数
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointcut() {

    }

    // 通知：连接点前、后、返回值、抛异常、连接点前后。
    @Before("pointcut()")// 针对该切点pointcut()
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterRetuning() {
        System.out.println("afterRetuning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {// 参数：连接点
        System.out.println("around before");
        Object obj = joinPoint.proceed();// 连接点调用目标组件的方法，返回目标组件的返回值
        System.out.println("around after");
        return obj;
    }

}
