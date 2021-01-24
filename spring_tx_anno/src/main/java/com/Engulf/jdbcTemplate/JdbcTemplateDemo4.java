package com.Engulf.jdbcTemplate;

import com.Engulf.dao.IAccountDao;
import com.Engulf.dao.impl.AccountDaoImpl;
import com.Engulf.domain.Champion;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的最基本用法
 */

public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", AccountDaoImpl.class);
        //3.执行操作
        Champion champion = accountDao.findChampionById(1);
        System.out.println(champion);

        champion.setGold(3000f);
        accountDao.updateChampion(champion);
    }
}
