package com.qiumingjie.springcloudapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author QiuMingJie
 * @date 2020-03-27 11:39
 * @description 用户实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String password;
    private String desc;

}

