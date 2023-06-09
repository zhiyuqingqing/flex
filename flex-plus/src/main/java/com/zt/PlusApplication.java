package com.zt;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
@Slf4j
public class PlusApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PlusApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
        log.info("容器启动成功.....");
    }
}