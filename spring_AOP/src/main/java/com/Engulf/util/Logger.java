package com.Engulf.util;

/**
 * 用于记录日志的工具类，里面提供了公共的方法
 */

public class Logger {
    /**
     * 用于打印日志，计划让其在切入点方法之前执行(切入点方法就是业务层方法)
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法执行");
    }
}
