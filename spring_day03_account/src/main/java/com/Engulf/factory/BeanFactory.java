package com.Engulf.factory;

import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import com.Engulf.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */

public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager tsManager;

    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }


    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     * @return
     */
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            tsManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService,args);
                            //3.提交事务
                            tsManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            tsManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            tsManager.release();
                        }
                    }
                });
    }
}
