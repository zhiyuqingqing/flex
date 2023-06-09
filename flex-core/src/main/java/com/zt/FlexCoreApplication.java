package com.zt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
@Slf4j
public class FlexCoreApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(FlexCoreApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
        log.info("容器启动成功.....");
    }
}