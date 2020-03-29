package com.qiumingjie.springcloudapi.api;

import com.qiumingjie.springcloudapi.api.dto.User;
import com.qiumingjie.springcloudcommon.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author QiuMingJie
 * @date 2020-03-27 11:40
 * @description
 */
public interface MemberApi {

    /**
     * 获取用户基本信息接口
     *
     * @return 用户基本信息
     */
    @RequestMapping("/member/getMember")
    public ResponseBase getMember();

    @RequestMapping("/member/getCurrentMember")
    public ResponseBase getCurrentMember();

    @RequestMapping("/member/getUser")
    public String fff(User user);
}
