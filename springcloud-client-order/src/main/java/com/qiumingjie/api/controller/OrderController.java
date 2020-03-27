package com.qiumingjie.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-03-17 17:19
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public String getNumber() {
        String forObject = restTemplate.getForObject("http://app-itmayiedu-member/member/getMember", String.class);
        return forObject;
    }

    /**
     * 本地负载均衡大概实现基础,请求总数%服务总数
     * @return
     */
    @RequestMapping("/getMember")
    public List<ServiceInstance> getOrder() {
        List<ServiceInstance> getOrder = discoveryClient.getInstances("APP-ITMAYIEDU-MEMBER");
        getOrder.forEach(System.out::println);
        return getOrder;
    }


}
