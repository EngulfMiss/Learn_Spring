package com.Engulf.service.impl;

import com.Engulf.service.IAccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("保存账户");
    }

    @Override
    public void updateAccount(int i, String str) {
        System.out.println("更新账户"+i);
    }

    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }

}
