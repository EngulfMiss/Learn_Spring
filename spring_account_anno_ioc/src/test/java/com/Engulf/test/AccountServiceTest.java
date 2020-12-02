package com.Engulf.test;

import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("acService");
        //3.执行方法
        List<Champion> champions = as.findAllChampion();
        for(Champion ch:champions){
            System.out.println(ch);
        }
    }

    @Test
    public void testFindById(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("acService");
        //3.执行方法
        Champion champion = as.findChampionById(1);
        System.out.println(champion);
    }

    @Test
    public void testSave(){
        Champion champion = new Champion();
        champion.setName("QSJ");
        champion.setGold(99999f);
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("acService");
        as.saveChampion(champion);
    }

    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("acService");
        //3.查询出来再更新
        Champion champion = as.findChampionById(2);
        champion.setGold(999f);
        as.updateChampion(champion);
    }

    @Test
    public void testDelete(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as = (IAccountService) ac.getBean("acService");
        //3.执行方法
        as.deleteChampion(7);
    }
}
