package com.Engulf.test;

import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试，测试我们的配置
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

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
