package com.Engulf.test;

import com.Engulf.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试AOP配置
 */

public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = (IAccountService)ac.getBean("acService");
        //3.执行方法
        as.saveAccount();
        as.updateAccount(2,"Gnar");
        as.deleteAccount();
    }
}
