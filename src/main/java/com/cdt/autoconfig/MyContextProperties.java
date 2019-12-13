package com.cdt.autoconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: wujianmin
 * @Date: 2019/12/9 16:16
 * @Function:
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "my.context")
public class MyContextProperties {
    private Boolean enable;

    private String context;

    private String content;
}
