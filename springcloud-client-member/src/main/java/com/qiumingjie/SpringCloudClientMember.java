package com.qiumingjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//假设用zookeeper作为注册中心
//@EnableDiscoveryClient
public class SpringCloudClientMember {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientMember.class, args);
    }

}
