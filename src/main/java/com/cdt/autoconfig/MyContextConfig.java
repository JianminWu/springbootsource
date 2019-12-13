package com.cdt.autoconfig;

import lombok.Data;

/**
 * @Author: wujianmin
 * @Date: 2019/12/9 16:19
 * @Function:
 * @Version 1.0
 */
@Data
public class MyContextConfig {

    private String context;

    private String content;

    public MyContextConfig(String context, String content) {
        this.context = context;
        this.content = content;
    }
}
