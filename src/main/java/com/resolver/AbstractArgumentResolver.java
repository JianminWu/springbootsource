package com.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger log = LoggerFactory.getLogger(AbstractArgumentResolver.class);
    @Autowired
    protected ConversionService conversionService;

    public AbstractArgumentResolver() {
    }

    protected Object handleDto(MethodParameter parameter, Map<String, String> dtos) {
        dtos.remove("page");
        dtos.remove("size");
        dtos.remove("sort");
        Class genricType = this.getGenricType(parameter);
        if (genricType != null) {
            String data = (String) dtos.get("data");
            if (ClassUtils.isPrimitiveOrWrapper(genricType)) {
                return this.conversionService.convert(data, genricType);
            } else {
                return String.class.isAssignableFrom(genricType) ? data : this.getBeanWrapper(genricType, dtos);
            }
        } else {
            return null;
        }
    }

    protected Class getGenricType(MethodParameter parameter) {
        ParameterizedType genericParameterType = (ParameterizedType) parameter.getGenericParameterType();
        if (genericParameterType != null) {
            Type[] actualTypeArguments = genericParameterType.getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length == 1) {
                return (Class) actualTypeArguments[0];
            }
        }

        return null;
    }

    private Object getBeanWrapper(Class genricType, Map<String, String> dtos) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(genricType);
        beanWrapper.setConversionService(this.conversionService);
        Iterator var4 = dtos.entrySet().iterator();

        while (var4.hasNext()) {
            Map.Entry entry = (Map.Entry) var4.next();

            try {
                if (!((String) entry.getKey()).equals("t")) {
                    beanWrapper.setPropertyValue((String) entry.getKey(), entry.getValue());
                }
            } catch (NotWritablePropertyException var7) {
                log.error("设置bean属性值失败:{}", var7);
            }
        }

        return beanWrapper.getWrappedInstance();
    }

    protected static void injectDetect(String value) {
        if (!StringUtils.isEmpty(value)) {
            Pattern pattern = Pattern.compile(".*([';]+|(--)+).*");
            Matcher matcher = pattern.matcher(value);

            while (matcher.find()) {
                new RuntimeException("不能查询特殊字符");
            }

        }
    }
}
