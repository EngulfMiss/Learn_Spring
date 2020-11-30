package qsj.Engulf.service.impl;

import qsj.Engulf.dao.IAccountDao;
import qsj.Engulf.dao.impl.AccountDaoImpl;
import qsj.Engulf.service.IAccountService;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

    /**
     * 业务层调用持久层
     */
    //改造
    private IAccountDao accountDao = null;

    public AccountServiceImpl(){
        System.out.println("AccountServiceImpl对象被创建");
    }


    public void saveAccount() {
        accountDao.saveAccount();
    }
}
