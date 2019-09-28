package com.spring.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author : Hens
 * @date : 2019/9/28 20:56
 */
public class GateFilter extends ZuulFilter {
    /**
     * 默认做不到当前截断  也就是说 我们的过滤器 还会往下进行下一个顾虑器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Cross Zuul");
        return null;
    }
}
