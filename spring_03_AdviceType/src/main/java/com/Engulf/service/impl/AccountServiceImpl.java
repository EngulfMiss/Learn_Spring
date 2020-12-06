package com.Engulf.service.impl;

import com.Engulf.service.IAccountService;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("保存了账户");
//        int i = 1/0;
    }

    public void updateAccount(int i,String str) {
        System.out.println("完成了更新");
    }

    public int deleteAccount() {
        System.out.println("完成了删除");
        return 0;
    }
}
