package com.Engulf.proxy;

/**
 * 生产者，厂家(被代理对象)
 */

public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，获得金币:" + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务，并获得金币:" + money);
    }
}
