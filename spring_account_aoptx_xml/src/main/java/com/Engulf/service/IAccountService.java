package com.Engulf.service;

import com.Engulf.domain.Champion;

import java.util.List;

/**
 * 账户的业务层接口
 */

public interface IAccountService {
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
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param gold 转出金额
     */
    void transfer(String sourceName, String targetName, Float gold);
}
