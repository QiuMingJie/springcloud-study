package com.qiumingjie.springcloudcommon.base;

/**
 * @author QiuMingJie
 * @date 2020-03-27 16:06
 * @description
 */
public class BaseApiService {

    public static ResponseBase setResultError(Integer code, String msg) {
        return setResult(code, msg, null);
    }

    // 返回错误，可以传msg
    public static ResponseBase setResultError(String msg) {
        return setResult(500, msg, null);
    }

    // 返回成功，可以传data值
    public static ResponseBase setResultSuccess(Object data) {
        return setResult(200, "处理成功", data);
    }

    // 返回成功，沒有data值
    public static ResponseBase setResultSuccess() {
        return setResult(200, "处理成功", null);
    }

    // 返回成功，沒有data值
    public static ResponseBase setResultSuccess(String msg) {
        return setResult(200, msg, null);
    }

    // 通用封装
    public static ResponseBase setResult(Integer code, String msg, Object data) {
        return new ResponseBase(code, msg, data);
    }

    public static void main(String[] args) {
    }
}
