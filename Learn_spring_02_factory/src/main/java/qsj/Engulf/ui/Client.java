package qsj.Engulf.ui;

import qsj.Engulf.factory.BeanFactory;
import qsj.Engulf.service.IAccountService;
import qsj.Engulf.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */

public class Client {
    public static void main(String[] args) {
        //改造
        //IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            //多例对象，执行效率较低;单例对象有线程问题
            IAccountService as = (IAccountService) BeanFactory.getBean("Service");
            System.out.println(as);
            as.saveAccount();
        }
//
    }
}
