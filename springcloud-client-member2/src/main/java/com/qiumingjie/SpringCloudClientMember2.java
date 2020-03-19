package com.qiumingjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudClientMember2 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientMember2.class, args);
    }

}
