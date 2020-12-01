package com.Engulf.ui;

import com.Engulf.dao.IAccountDao;
import com.Engulf.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as  = (IAccountService)ac.getBean("accountService");
        /*IAccountService as2  = (IAccountService)ac.getBean("accountService");
        System.out.println(as == as2);*/

        as.saveAccount();
        ac.close();
    }
}
