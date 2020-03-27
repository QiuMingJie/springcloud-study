package com.qiumingjie.feign;

import com.qiumingjie.springcloudapi.api.MemberApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author QiuMingJie
 * @date 2020-03-25 21:11
 * @description
 */
@FeignClient(name = "app-itmayiedu-member")
public interface MemberApiFeign  extends MemberApi {
}
