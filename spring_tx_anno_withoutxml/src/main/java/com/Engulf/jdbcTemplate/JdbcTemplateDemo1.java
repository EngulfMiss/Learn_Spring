package com.Engulf.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 */

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //准备数据源:spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("52snowgnar");

        //1.创建JdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //2.执行操作(sql里面的浮点型 不用加f)
        jt.execute("insert into account(id,name,gold) values(3,'Neeko',1000)");
    }
}
