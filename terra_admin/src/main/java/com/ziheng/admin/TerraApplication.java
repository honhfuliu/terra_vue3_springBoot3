package com.ziheng.admin;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ziheng")
public class TerraApplication {
    public static void main(String[] args) {
        SpringApplication.run(TerraApplication.class, args);
    }
}