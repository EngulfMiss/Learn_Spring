package com.Engulf.dao;

import com.Engulf.domain.Champion;

/**
 * 账户的持久层接口
 */

public interface IAccountDao {
    /**
     * 根据id查询账户
     * @param ChampionId
     * @return
     */
    Champion findChampionById(Integer ChampionId);

    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Champion findChampionByName(String name);

    /**
     * 更新账户
     * @param champion
     */
    void updateChampion(Champion champion);
}
