package qsj.Engulf.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import qsj.Engulf.service.IAccountService;

import java.util.logging.XMLFormatter;

/**
 * 模拟一个表现层，用于调用业务层
 */

public class Client {
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = ac.getBean("acService",IAccountService.class);
        as.saveAccount();

        //2.根据id获取bean对象

        IAccountService as2 = ac.getBean("acService2",IAccountService.class);
        as2.saveAccount();

        IAccountService as3 = ac.getBean("acService3",IAccountService.class);
        as3.saveAccount();

    }
}
