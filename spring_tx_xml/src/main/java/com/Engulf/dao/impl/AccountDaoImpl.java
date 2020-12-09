package com.Engulf.dao.impl;

import com.Engulf.dao.IAccountDao;
import com.Engulf.domain.Champion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 账户的持久层实现类
 */

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{

    @Override
    public Champion findChampionById(Integer ChampionId) {
        List<Champion> champions = getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Champion>(Champion.class),ChampionId);
        return champions.isEmpty()?null:champions.get(0);
    }


    @Override
    public Champion findChampionByName(String name) {
        List<Champion> champions = getJdbcTemplate().query("select * from account where name = ?",new BeanPropertyRowMapper<Champion>(Champion.class),name);
        if (champions.isEmpty()){
            return null;
        }
        if (champions.size() > 1){
            throw new RuntimeException("结果不唯一");
        }
        return champions.get(0);
    }


    @Override
    public void updateChampion(Champion champion) {
        getJdbcTemplate().update("update account set gold = ? where id = ?",champion.getGold(),champion.getId());
    }
}
