package com.Engulf.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */

public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource ds;

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        try {
        //2.判断当前线程上是否有连接
            if(conn == null){
                //3.从数据源中获取一个连接,并且存入ThreadLocal中
                conn = ds.getConnection();
                //4.将连接存入ThreadLocal中
                tl.set(conn);
            }
            //5.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
