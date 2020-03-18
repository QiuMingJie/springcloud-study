package com.qiumingjie.springcloudclientmember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudClientMember {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientMember.class, args);
    }

}
