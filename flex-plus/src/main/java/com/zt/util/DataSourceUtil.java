package com.zt.util;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-09  10:57
 * @Description: 数据源切换工具
 * @Version: 1.0
 */
public class DataSourceUtil {
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DS = "db1";
    /**
     *  数据源属于一个公共的资源
     *  采用ThreadLocal可以保证在多线程情况下线程隔离
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源名
     * @param dbType
     */
    public static void setDB(String dbType) {
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名
     * @return
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源名
     */
    public static void clearDB() {
        contextHolder.remove();
    }
}
