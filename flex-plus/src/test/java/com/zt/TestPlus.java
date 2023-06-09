package com.zt;

import com.zt.plus.mapper.TestMapper;
import com.zt.util.DataSourceUtil;
import com.zt.util.RedisTemplateUtil;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testInsert2() {
        Object name = RedisTemplateUtil.get("name");
        System.out.println(name);
    }
}
