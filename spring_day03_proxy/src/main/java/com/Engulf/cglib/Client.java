package com.Engulf.cglib;

import com.Engulf.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         *          基于子类的动态代理
         *              涉及的类：Enhancer
         *              提供者:第三方cglib库
         *          如何创建代理对象：
         *              使用Enhancer类中的create方法
         *          创建代理对象的要求：
         *              被代理类不能是最终类
         *          create方法的参数：
         *              Class：字节码
         *                  它是用于指定被代理对象的字节码
         *              Callback:用于提供增强代码
         *                  我们一般写的都是该接口的子接口实现类，MethodInterceptor(方法拦截)
         */
        Producer cglibProducer = (Producer) Enhancer.create(p1.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象的任何方法都会经过此方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法所需的参数
             *      以上三个参数与基于接口的动态代理中invoke方法的参数是一样的
             * @param methodProxy：当前执行方法的代理对象
             * @return 和被代理对象有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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

        cglibProducer.saleProduct(9000f);
    }
}
