package com.Engulf.service.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.domain.Champion;
import com.Engulf.service.IAccountService;
import com.Engulf.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 */

public class AccountServiceImpl_Old implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager tsManager;

    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Champion> findAllChampion() {
        try {
            //1.开启事务
            tsManager.beginTransaction();
            //2.执行操作
            List<Champion> champions = accountDao.findAllChampion();
            //3.提交事务
            tsManager.commit();
            //4.返回结果
            return champions;
        }catch (Exception e){
            //5.回滚操作
            tsManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            tsManager.release();
        }
    }

    @Override
    public Champion findChampionById(Integer championId) {
        try {
            //1.开启事务
            tsManager.beginTransaction();
            //2.执行操作
            Champion champion = accountDao.findChampionById(championId);
            //3.提交事务
            tsManager.commit();
            //4.返回结果
            return champion;
        } catch (Exception e) {
            //5.回滚操作
            tsManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tsManager.release();
        }
    }

    @Override
    public void saveChampion(Champion champion) {
            try {
                //1.开启事务
                tsManager.beginTransaction();
                //2.执行操作
                accountDao.saveChampion(champion);
                //3.提交事务
                tsManager.commit();
            }catch (Exception e){
                //5.回滚操作
                tsManager.rollback();
            }finally {
                //6.释放连接
                tsManager.release();
            }
    }

    @Override
    public void updateChampion(Champion champion) {
            try {
                //1.开启事务
                tsManager.beginTransaction();
                //2.执行操作
                accountDao.updateChampion(champion);
                //3.提交事务
                tsManager.commit();
            }catch (Exception e){
                //5.回滚操作
                tsManager.rollback();
            }finally {
                //6.释放连接
                tsManager.release();
            }
    }

    @Override
    public void deleteChampion(Integer championId) {
            try {
                //1.开启事务
                tsManager.beginTransaction();
                //2.执行操作
                accountDao.deleteChampion(championId);
                //3.提交事务
                tsManager.commit();
            }catch (Exception e){
                //5.回滚操作
                tsManager.rollback();
            }finally {
                //6.释放连接
                tsManager.release();
            }
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
            try {
                //1.开启事务
                tsManager.beginTransaction();
                //2.执行操作
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
                int i = 1/0;

                //2.6更新转入账户
                accountDao.updateChampion(target);
                //3.提交事务
                tsManager.commit();
            }catch (Exception e){
                //5.回滚操作
                tsManager.rollback();
                e.printStackTrace();
            }finally {
                //6.释放连接
                tsManager.release();
            }
    }
}
