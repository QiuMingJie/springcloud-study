package com.qiumingjie.springcloudserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServer2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServer2.class, args);
    }

}
