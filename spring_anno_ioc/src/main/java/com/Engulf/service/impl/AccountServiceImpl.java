package com.Engulf.service.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * xml方式的配置
 * <bean id="accountService" class="com.Engulf.service.impl.AccountServiceImpl"
 * scope="" init-method="" destroy-method="" >
 *      <property name"" value="" / ref=""></property>
 * </bean>
 *
 * 用于创建对象的注解
 *      他们的作用就和在XML配置文件中编写一个<bean>标签实现的功能一样
 *      @Componet:
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写
 *
 *      @Controller：一般用在表现层
 *      @Service：一般用于业务层
 *      @Repository：一般用于持久层
 *      以上三个注解他们的作用和属性与Component是一模一样的。
 *      他们三个是spring框架为我们提供明确的三次使用的注解，使我们三层对象更加清晰
 *
 *--------------------------------------------------------------------------------------
 *
 *
 * 用于注入数据的注解
 *      他们的作用就和在XML配置文件中编写一个<property>标签实现的功能一样
 *      @Autowired
 *          作用：自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *                如果IOC容器中一个匹配的类型都没有，那么注入会失败，报错
 *                如果IOC容器中有多个匹配的类型时，除非有变量名称和bean的注解名称相同任然可以注入成功，如果没有就报错
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *          细节：
 *              在使用注解注入时，set方法就不是必须的了
 *
 *
 *      @Qualifier
 *          作用：在按照类型注入的基础上再按照名称注入，它在给类成员注入时不能单独使用，但是在给方法参数注入时可以
 *          属性：
 *              value：用于指定注入bean的id。
 *
 *
 *      @Resource
 *          作用：直接按照bean的id注入。可以独立使用
 *          属性：
 *              name：用于指定bean的id
 *
 *      以上三个注解都只能注入其他bean类型的数据，基本类型和String类型无法使用上述注解
 *      另外，集合类型的注入只能通过XML来实现
 *
 *
 *      @Value
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中SpEL(也就是spring的EL表达式)
 *                      SpEL的写法：${表达式}
 *
 *
 *------------------------------------------------------------------------------------
 *
 *
 * 用于改变作用范围的
 *      他们的作用就和在XML配置文件中编写一个<scope>标签实现的功能一样
 *      Scope
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值 singleton prototype
 *
 *
 *--------------------------------------------------------------------------
 *
 * 和生命周期相关的:(了解)
 *      他们的作用就和在XML配置文件中编写一个<init-method>和<destroy-method>标签实现的功能一样
 *      PreDestroy
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */
@Component("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {

/*    @Autowired
    @Qualifier("acDao2")*/
    @Resource(name = "acDao")
    private IAccountDao accountDao = null;

    @PostConstruct
    public void init(){
        System.out.println("我是一只初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("我是一只销毁方法");
    }

    public void  saveAccount(){
        accountDao.saveAccount();
    }
}
