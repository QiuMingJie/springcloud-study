package com.qiumingjie.springcloudservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudService1 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudService1.class, args);
    }

}