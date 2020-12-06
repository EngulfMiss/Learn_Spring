package com.Engulf.service.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import com.Engulf.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Champion> findAllChampion() {
        return accountDao.findAllChampion();
    }

    @Override
    public Champion findChampionById(Integer championId) {
        return accountDao.findChampionById(championId);
    }

    @Override
    public void saveChampion(Champion champion) {
            accountDao.saveChampion(champion);
    }

    @Override
    public void updateChampion(Champion champion) {
            accountDao.updateChampion(champion);
    }

    @Override
    public void deleteChampion(Integer championId) {
            accountDao.deleteChampion(championId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float gold) {
        /**
         * 每一次accountDao的使用，都会获取一次连接，成功的执行就会被提交
         * 出现异常后，不会被提交，并不是没有事务。
         * 简而言之，存在多个connection所以会出现事务问题
         * 需要使用ThreadLocal对象把Connection和当前线程绑定，从而使一个
         * 线程中只有一个控制事务的对象
         */
                System.out.println("transfer..........");
                //2.1根据名称查询转出账户
                Champion source = accountDao.findChampionByName(sourceName);
                //2.2根据名称查询转入账户
                Champion target = accountDao.findChampionByName(targetName);
                //2.3转出账户减钱
                source.setGold(source.getGold() - gold);
                //2.4转入账户加钱
                target.setGold(target.getGold()+gold);
                //2.5更新转出账户
                accountDao.updateChampion(source);

                //手动异常
//                int i = 1/0;

                //2.6更新转入账户
                accountDao.updateChampion(target);
    }
}
