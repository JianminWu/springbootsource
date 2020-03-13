package com.cdt.resolver;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cdt.util.QueryRequest;
import com.google.common.base.Charsets;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletInputStream;

/**
 * @Author: wujianmin
 * @Date: 2019/12/16 17:35
 * @Function:
 * @Version 1.0
 */
@Component
public class RequestParameterfResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //  参数resolver 包装校验逻辑
        return QueryRequest.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServletInputStream inputStream = ((ServletWebRequest) webRequest).getRequest().getInputStream();
        String body = IoUtil.read(inputStream, Charsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(body);
        QueryRequest queryRequest = new QueryRequest();
        queryRequest.setQuery(JSON.parseObject(jsonObject.getString("query"), QueryRequest.Query.class));
        queryRequest.setSorts(JSON.parseArray(jsonObject.getString("sorts"), QueryRequest.Sort.class));
        queryRequest.setPageInfo(JSON.parseObject(jsonObject.getString("page"), QueryRequest.PageInfo.class));
        return queryRequest;
    }
}
