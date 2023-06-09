package com.zt;

import com.zt.plus.domain.Test;
import com.zt.plus.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: zhoutian
 * @CreateTime: 2023-06-08  18:00
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPlus {
    @Autowired
    TestMapper testMapper;

    @org.junit.jupiter.api.Test
    public void testInsert1() {
        Test test = testMapper.selectOneById(3L);
        System.out.println(test);
    }
}
