package com.Engulf.proxy;

/**
 * 对生产厂家要求的接口
 */

public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public abstract void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public abstract void afterService(float money);
}
