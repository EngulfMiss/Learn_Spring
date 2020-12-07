package com.Engulf.test;

import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public void testTransfer(){
        as.transfer("Gnar","Kindred",200f);
    }

}
