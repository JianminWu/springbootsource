package com.cdt.filter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 16:34
 * @Function:
 * @Version 1.0
 */
public class SafeCheckFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String pathInfo = request.getPathInfo();
        return true;
    }
}
