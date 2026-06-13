package com.ziheng.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI 文档的全局元信息
 */
@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI terraOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Terra API")
                        .contact(new Contact().name("ziheng"))
                        .description("Terra 后台管理系统接口文档")
                        .version("1.0.0"));
    }
}
