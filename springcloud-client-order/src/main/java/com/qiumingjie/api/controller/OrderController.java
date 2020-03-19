package com.qiumingjie.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author QiuMingJie
 * @date 2020-03-17 17:19
 * @description
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public String getNumber() {
        String forObject = restTemplate.getForObject("http://app-itmayiedu-member/getMember", String.class);
        return forObject;
    }
}
