package com.qiumingjie.springcloudserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServer1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServer1.class, args);
    }

}