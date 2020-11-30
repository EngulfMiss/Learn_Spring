package qsj.Engulf.service.impl;

import qsj.Engulf.dao.IAccountDao;
import qsj.Engulf.dao.impl.AccountDaoImpl;
import qsj.Engulf.factory.BeanFactory;
import qsj.Engulf.service.IAccountService;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

    /**
     * 业务层调用持久层
     */
    //改造
    //private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("Dao");


    @Override
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
