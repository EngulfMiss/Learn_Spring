package com.Engulf.dao;

import com.Engulf.domain.Champion;

import java.util.List;

/**
 * 账户的持久层接口
 */

public interface IAccountDao {
    /**
     * 查询所有英雄的方法
     * @return
     */
    List<Champion> findAllChampion();

    /**
     * 通过id查找某一个英雄
     * @return
     */
    Champion findChampionById(Integer championId);

    /**
     * 保存操作
     * @param champion
     */
    void saveChampion(Champion champion);

    /**
     * 更新操作
     * @param champion
     */
    void updateChampion(Champion champion);

    /**
     * 删除操作
     * @param championId
     */
    void deleteChampion(Integer championId);

    /**
     * 根据名称查询账户
     * @param championName
     * @return 有唯一一个就返回，没有返回null，有多个抛异常
     */
    Champion findChampionByName(String championName);
}
