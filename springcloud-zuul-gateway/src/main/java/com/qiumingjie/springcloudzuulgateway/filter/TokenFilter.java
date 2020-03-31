package com.qiumingjie.springcloudzuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author QiuMingJie
 * @date 2020-03-31 13:48
 * @description 配置网关拦截器，拦截一下token
 */
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 拦截类型。pre就是在前面
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置多个zuul时候路由执行顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 需要启动路由拦截
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 主体，做的事情
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String userToken = request.getParameter("userToken");
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(userToken)||StringUtils.isEmpty(token)) {
            HttpServletResponse response = requestContext.getResponse();
            response.setStatus(405);
            requestContext.setResponseBody("找不到token");
            response.setHeader("content-Type","text/html;charset=UTF-8");
            //停止，不再继续往下执行
            requestContext.setSendZuulResponse(false);
            return null;
        }
        return null;
    }
}
