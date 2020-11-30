package qsj.Engulf.service.impl;

import qsj.Engulf.service.IAccountService;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象被创建");
    }


    public void saveAccount() {
        System.out.println("servive中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("对象初始化");
    }

    public void destroy(){
        System.out.println("对象被销毁了");
    }
}
