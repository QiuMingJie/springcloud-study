package com.qiumingjie.api.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiumingjie.feign.MemberApiFeign;
import com.qiumingjie.springcloudcommon.base.BaseApiService;
import com.qiumingjie.springcloudcommon.base.ResponseBase;
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
    private MemberApiFeign memberApiFeign;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    public String getNumber() {
        String forObject = restTemplate.getForObject("http://app-itmayiedu-member/member/getMember", String.class);
        return forObject;
    }

    /**
     * 本地负载均衡大概实现基础,请求总数%服务总数
     *
     * @return
     */
    @RequestMapping("/getMemberList")
    public List<ServiceInstance> getOrder() {
        List<ServiceInstance> getOrder = discoveryClient.getInstances("APP-ITMAYIEDU-MEMBER");
        getOrder.forEach(System.out::println);
        return getOrder;
    }

    /**
     * 解决服务雪崩效应
     * 开启hystrix，使用@hystrix时默认开启线程池隔离方式，开启服务降级，开启服务熔断机制
     * fallbackMethod指定服务降级时返回值
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallBackMethod")
    @RequestMapping("/getMember")
    public ResponseBase getMember() {
        System.out.println("开启了服务保护机制,线程名："+Thread.currentThread().getName());
        return memberApiFeign.getMember();
    }

    @RequestMapping("/getMember1")
    public ResponseBase getMember1() {
        System.out.println("开启了服务保护机制,线程名："+Thread.currentThread().getName());
        return memberApiFeign.getMember();
    }

    @RequestMapping("/getCurrentMember")
    public ResponseBase getCurrentMember() {
        System.out.println("没开启服务保护机制,线程名："+Thread.currentThread().getName());
        return memberApiFeign.getCurrentMember();
    }

    public ResponseBase fallBackMethod() {
        return BaseApiService.setResultSuccess("系统繁忙，请稍后再试");
    }
}
