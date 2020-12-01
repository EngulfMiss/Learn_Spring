package com.Engulf.dao.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.domain.Champion;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */

public class AccountDaoImpl implements IAccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Champion> findAllChampion() {
        try {
            return runner.query("select * from account",new BeanListHandler<Champion>(Champion.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Champion findChampionById(Integer championId) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Champion>(Champion.class),championId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveChampion(Champion champion) {
        try {
            runner.update("insert into account(name,gold) values(?,?)",champion.getName(),champion.getGold());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateChampion(Champion champion) {
        try {
            runner.update("update account set name=?,gold=? where id=?",champion.getName(),champion.getGold(),champion.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteChampion(Integer championId) {
        try {
            runner.update("delete from account where id=?",championId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
