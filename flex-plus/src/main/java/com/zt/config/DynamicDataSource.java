package com.zt.config;

import com.zt.util.DataSourceUtil;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-09  10:56
 * @Description: 动态数据源类
 * @Version: 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceUtil.getDB();
    }
}
