package com.zt.config;

import cn.hutool.Hutool;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-09  10:54
 * @Description: Swagger3Config
 * @Version: 1.0
 */
@Configuration
@EnableCaching
public class CacheConfiguration {
    public static void main(String[] args) {
        Hutool.printAllUtils();
    }

    @Bean(name = "oneHourCacheManager")
    public CacheManager oneHourCacheManager() {
        Caffeine caffeine = Caffeine.newBuilder()
                .initialCapacity(10) //初始大小
                .maximumSize(100)  //最大大小
                .expireAfterWrite(1, TimeUnit.HOURS); //写入/更新之后1小时过期

        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setAllowNullValues(true);
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }
}



