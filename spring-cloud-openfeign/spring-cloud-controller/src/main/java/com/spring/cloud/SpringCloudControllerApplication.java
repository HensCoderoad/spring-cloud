package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudControllerApplication.class, args);
    }

}
