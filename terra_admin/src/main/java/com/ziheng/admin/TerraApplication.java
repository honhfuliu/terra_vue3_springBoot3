package com.ziheng.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ziheng")
public class TerraApplication {
    public static void main(String[] args) {
        SpringApplication.run(TerraApplication.class, args);
    }
}