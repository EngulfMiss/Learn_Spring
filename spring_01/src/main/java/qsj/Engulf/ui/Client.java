package qsj.Engulf.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import qsj.Engulf.dao.IAccountDao;
import qsj.Engulf.service.IAccountService;

import java.util.logging.XMLFormatter;

/**
 * 模拟一个表现层，用于调用业务层
 */

public class Client {
    public static void main(String[] args) {
        /**
         * 获取spring的ioc核心容器，并根据id获取对象
         *
         * ApplicationContext的三个常用实现类
         *      - ClassPathApplicationContext:加载类路径下的配置文件,要求配置文件必须在类路径下
         *      - FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件(必须有访问权限)
         *      - AnnotationConfigApplicationContext:它用于读取注解创建容器的
         *
         *
         * 核心容器的两个接口引发出的问题
         * ApplicationContext: 单例对象适用
         *      它在构建核心容器时，创建对象的策略是采用立即加载的方式。就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
         * BeanFactory: 多例对象适用
         *      它在创建对象容器时，创建对象采取的策略是采用延迟加载方式，就是说，什么时候根据id获取对象了，什么时候才真正创建对象
         */

        /*
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = ac.getBean("acService",IAccountService.class);
        IAccountDao ad = (IAccountDao)ac.getBean("acDao");
        System.out.println(as);
        System.out.println(ad);
        */

        //------------ BeanFactory  --------------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = factory.getBean("acService",IAccountService.class);
        IAccountDao ad = factory.getBean("acDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(ad);


    }
}
