package com.Engulf.util;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，里面提供了公共的方法
 */

public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知方法执行");
    }

    /**
     * 后置通知
     */
    public void afterPrintLog(){
        System.out.println("后置通知方法执行");
    }

    /**
     * 异常通知
     */
    public void ThrowingPrintLog(){
        System.out.println("异常通知方法执行");
    }

    /**
     * 最终通知
     */
    public void finalPrintLog(){
        System.out.println("最终通知方法执行");
    }

    /**
     * 环绕通知
     *      问题：
     *          当我们配置了环绕通知后，切入点方法没有执行，而通知方法执行了
     *
     *      分析：
     *          通过对比动态代理的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法的调用
     *
     *      解决：
     *          Spring框架为我们提供了一个接口，ProceedingJoinPoint.该接口有一个方法proceed(),
     *          此方法就相当于明确调用切入点方法，该接口可以作为环绕通知的方法参数，在程序执行时，
     *          spring框架会为我们提供该接口的实现类供我们使用
     *
     *      spring中的环绕通知：
     *          它是spring框架为我们提供的一种可以代码中手动控制增强方法何时执行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        //明确调用业务层方法(切入点方法)
        try {
            Object[] args = pjp.getArgs();//得到方法执行时需要的参数

            System.out.println("环绕通知(前置)方法执行");

            pjp.proceed();

            System.out.println("环绕通知(后置)方法执行");


            return rtValue;
        } catch (Throwable t) {
            System.out.println("环绕通知(异常)方法执行");
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知(最终)方法执行");
        }
    }
}
