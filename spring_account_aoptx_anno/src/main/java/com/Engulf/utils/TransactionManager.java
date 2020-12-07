package com.Engulf.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类
 *      包含：开启事务，提交事务，回滚事务和释放连接
 */

@Component("txManager")
@Aspect //表明当前类是一个切面类
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.Engulf.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try{
            connectionUtils.getThreadConnection().close();  //归还到连接池
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事务
            this.beginTransaction();
            //3.执行方法
            rtValue = pjp.proceed(args);
            //4.提交事务
            this.commit();
            //返回结果
            return rtValue;
        }catch (Throwable t){
            //5.回滚事务
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            //6.释放资源
            this.release();
        }
    }
}
