package com.chenzhi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务
@EnableScheduling
@MapperScan("com.chenzhi.mapper")
public class LogisticsManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsManagementApplication.class,args);
    }
}
