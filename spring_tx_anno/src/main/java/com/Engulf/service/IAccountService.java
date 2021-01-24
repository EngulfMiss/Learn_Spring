package com.Engulf.service;

import com.Engulf.domain.Champion;

/**
 * 账户的业务层接口
 */

public interface IAccountService {
    /**
     * 根据id查询账户信息
     * @param ChampionId
     * @return
     */
    Champion findChampionById(Integer ChampionId);

    /**
     * 转账
     * @param sourceName 转账人名称
     * @param targetName 收款人名称
     * @param gold 钱
     */
    void transfer(String sourceName, String targetName, Float gold);
}
