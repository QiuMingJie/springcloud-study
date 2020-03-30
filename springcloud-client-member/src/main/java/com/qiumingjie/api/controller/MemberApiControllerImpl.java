package com.qiumingjie.api.controller;

import com.qiumingjie.springcloudapi.api.MemberApi;
import com.qiumingjie.springcloudapi.api.dto.User;
import com.qiumingjie.springcloudcommon.base.BaseApiService;
import com.qiumingjie.springcloudcommon.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-03-18 15:55
 * @description
 */
@RestController
@RequestMapping("/member")
public class MemberApiControllerImpl implements MemberApi {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @Override
    @RequestMapping("/getMember")
    public ResponseBase getMember() {
        System.out.println("开始调用member");
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成调用member");
        return BaseApiService.setResultSuccess(new User("xiaoqiu", "123456", Thread.currentThread().getName() + "端口是" + port));
    }

    @Override
    @RequestMapping("/getCurrentMember")
    public ResponseBase getCurrentMember() {
        return BaseApiService.setResultSuccess("fd");
    }

    @Override
    @RequestMapping("/getUser")
    public String fff(User user) {
        return user.toString();
    }

}
