package com.Engulf.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */

public class Client {
    public static void main(String[] args) {
        /**
         * 匿名内部类访问外部成员变量时，外部成员要求final修饰
         */
        final Producer p1 = new Producer();
        /**
         * 动态代理：
         *      特点：
         *          字节码随用随创建，随用随加载
         *      作用：
         *          不修改源码的基础上对方法进行增强
         *      分类：
         *          基于接口的动态代理
         *              涉及的类：Proxy
         *              提供者：JDK官方
         *          如何创建代理对象：
         *              使用Proxy类中的newProxyInstance方法
         *          创建代理对象的要求：
         *              被代理类至少实现一个接口，如果没有则不能使用
         *          newProxyInstance方法的参数：
         *              ClassLoader:
         *                  它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。代理谁写谁的
         *                  getClassLoader()
         *
         *              Class[]:
         *                  它是用于让代理对象和被代理对象有相同方法。代理谁写谁的getInterfaces()
         *
         *              InvocationHandler:用于提供增强的代码
         *                  它是让我们写如何代理。我们一般都是写一个该接口的实现类。
         *                  通常情况下都是匿名内部但不是必须的。
         *                  此接口的实现类都是谁用谁写。
         *
         *
         *          基于子类的动态代理
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(p1.getClass().getClassLoader(), p1.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return  和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object retuenValue = null;
                        //1.获取方法执行的参数
                        Float money = (Float)args[0];
                        //2.判断当前方法是不是销售
                        if("saleProduct".equals(method.getName())){
                            retuenValue = method.invoke(p1,money * 0.8f);
                        }
                        return retuenValue;
                    }
                });
        //代理对象调用方法
        proxyProducer.saleProduct(10000f);
    }
}
