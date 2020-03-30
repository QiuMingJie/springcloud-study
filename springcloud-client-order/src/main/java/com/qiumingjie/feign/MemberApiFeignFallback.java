package com.qiumingjie.feign;

import com.qiumingjie.springcloudapi.api.dto.User;
import com.qiumingjie.springcloudcommon.base.BaseApiService;
import com.qiumingjie.springcloudcommon.base.ResponseBase;
import org.springframework.stereotype.Component;

/**
 * @author QiuMingJie
 * @date 2020-03-30 21:30
 * @description 服务降级友好提示类
 */
@Component
public class MemberApiFeignFallback implements MemberApiFeign {
    @Override
    public ResponseBase getMember() {
        return BaseApiService.setResultSuccess("服务降级了，getMember请等待");
    }

    @Override
    public ResponseBase getCurrentMember() {
        return BaseApiService.setResultSuccess("服务降级了，getCurrentMember请等待");
    }

    @Override
    public String fff(User user) {
        return "请等待";
    }
}
