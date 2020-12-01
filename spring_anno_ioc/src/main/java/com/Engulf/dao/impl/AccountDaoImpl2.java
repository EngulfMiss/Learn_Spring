package com.Engulf.dao.impl;

import com.Engulf.dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("acDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public  void saveAccount(){

        System.out.println("销毁了账户");
    }
}
