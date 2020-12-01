package com.Engulf.service.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;

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
}
