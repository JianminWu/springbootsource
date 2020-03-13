package com.cdt.config;

import com.cdt.filter.SafeCheckFilter;
import com.cdt.resolver.RequestParameterfResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 16:38
 * @Function:
 * @Version 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    RequestParameterfResolver requestParameterfResolver;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SafeCheckFilter()).addPathPatterns("/**").
                excludePathPatterns("/testBean/test");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/",".jsp");
        super.configureViewResolvers(registry);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(requestParameterfResolver);
        super.addArgumentResolvers(argumentResolvers);
    }
}
