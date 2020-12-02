package com.Engulf.test;

import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import config.SpringConfigration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合junit的配置
 *      1.导入spring整合junit的jar包(坐标)
 *      2.使用junit提供的一个注解把原有的main方法替换成spring提供的main方法
 *          @Runwith
 *      3.告知spring的运行器，spring的ioc创建是基于xml还是注解的，并且说明位置
 *          @ContextConfiguration
 *                  locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在位置(注解创建)
 *
 *      当我们使用spring5版本的时候，spring 5.x版本等等，要求junit的jar包必须是4.12几
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigration.class)
public class AccountServiceTest {

    /*@Autowired
    ApplicationContext ac = null;*/
    @Autowired
    IAccountService as = null;

/*    @Before
    public void init(){
        //1.获取容器
        ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
        //2.得到业务层对象
        as = (IAccountService) ac.getBean("acService");
    }*/

    @Test
    public void testFindAll(){
        //3.执行方法
        List<Champion> champions = as.findAllChampion();
        for(Champion ch:champions){
            System.out.println(ch);
        }
    }

    @Test
    public void testFindById(){
        //3.执行方法
        Champion champion = as.findChampionById(1);
        System.out.println(champion);
    }

    @Test
    public void testSave(){
        Champion champion = new Champion();
        champion.setName("QSJ");
        champion.setGold(99999f);
        as.saveChampion(champion);
    }

    @Test
    public void testUpdate(){
        //3.查询出来再更新
        Champion champion = as.findChampionById(2);
        champion.setGold(999f);
        as.updateChampion(champion);
    }

    @Test
    public void testDelete(){
        //3.执行方法
        as.deleteChampion(7);
    }
}
