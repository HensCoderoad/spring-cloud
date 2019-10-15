package com.funtl.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Hens
 * @date : 2019/9/13 15:01
 */
@SpringBootApplication
@MapperScan(basePackages = "com.funtl.oauth2.resources.mapper")
public class OAuth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceApplication.class, args);
    }
}
