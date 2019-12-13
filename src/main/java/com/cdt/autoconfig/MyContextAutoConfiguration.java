package com.cdt.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wujianmin
 * @Date: 2019/12/9 16:17
 * @Function:
 * @Version 1.0
 */
@Configuration
@ConditionalOnProperty(name = "my.context.enable", havingValue = "true")
@EnableConfigurationProperties(MyContextProperties.class)
public class MyContextAutoConfiguration {

    private final MyContextProperties contextProperties;

    public MyContextAutoConfiguration(MyContextProperties contextProperties) {
        this.contextProperties = contextProperties;
    }

    @Bean
    @ConditionalOnMissingBean(MyContextConfig.class)
    public MyContextConfig myContextConfig(MyContextProperties myContextProperties){
        return new MyContextConfig(contextProperties.getContext(),contextProperties.getContent());
    }
}
