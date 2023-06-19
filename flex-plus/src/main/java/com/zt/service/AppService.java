package com.zt.service;

import com.zt.plus.domain.Test;
import com.zt.plus.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-16  14:31
 * @Description: TODO
 * @Version: 1.0
 */
@Service
@Slf4j
public class AppService {
    @Autowired
    TestMapper testMapper;

    @Cacheable(cacheManager = "oneHourCacheManager", value = "human", key = "#name")
    public Test sendSmsCode(String name) {
        log.info("开始查询");
        return testMapper.selectById(1L);
    }
}
