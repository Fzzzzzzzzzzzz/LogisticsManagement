package com.chenzhi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chenzhi.mapper")
public class LogisticsManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogisticsManagementApplication.class,args);
    }
}
