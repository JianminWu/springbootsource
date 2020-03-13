package com.resolver;

import com.google.common.collect.Maps;
import com.resolver.util.ListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class ListRequestArgumentResolver extends AbstractArgumentResolver {
    @Autowired
    private SortHandlerMethodArgumentResolver sortHandlerMethodArgumentResolver;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return ListRequest.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        Map<String, Object> pageRequestMap = Maps.newHashMap();
        Map<String, String> dtos = Maps.newHashMap();
        for (Map.Entry<String, String[]> entry : webRequest.getParameterMap().entrySet()) {
            if (entry.getKey().contains("_")) {
                if (entry.getValue()[0] instanceof String) {
                    injectDetect(entry.getValue()[0]);
                }
                pageRequestMap.put(entry.getKey(), entry.getValue()[0]);
            } else {
                dtos.put(entry.getKey(), entry.getValue()[0]);
            }
        }
        Object dto = handleDto(parameter, dtos);
        ListRequest listRequest = new ListRequest();
        Sort sort = sortHandlerMethodArgumentResolver.resolveArgument(parameter, mavContainer, webRequest,
                binderFactory);
        listRequest.setSort(sort);
        listRequest.setMap(pageRequestMap);
        listRequest.setData(dto);
        return listRequest;
    }
}
