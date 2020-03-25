package com.qiumingjie.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-03-18 15:55
 * @description
 */
@RestController
@RequestMapping("/member")
public class MemberApiController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @Value("${server.port}")
    private String port;

    @RequestMapping("/getMember")
    public String getNumber() {
        return "调用到member，端口号为 " + port;
    }


    @RequestMapping("/getOrder")
    public List<ServiceInstance> getOrder() {
        List<ServiceInstance> getOrder = discoveryClient.getInstances("APP-ITMAYIEDU-MEMBER");
        getOrder.forEach(System.out::println);
        return getOrder;
    }
}
