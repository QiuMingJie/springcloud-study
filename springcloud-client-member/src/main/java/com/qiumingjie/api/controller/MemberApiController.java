package com.qiumingjie.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-03-18 15:55
 * @description
 */
@RestController
public class MemberApiController {
    @RequestMapping("/getMember")
    public String getNumber() {
        return "this is member ";
    }
}
