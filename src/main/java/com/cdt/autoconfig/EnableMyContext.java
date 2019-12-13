package com.cdt.autoconfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: wujianmin
 * @Date: 2019/12/9 16:20
 * @Function:
 * @Version 1.0
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyContextAutoConfiguration.class)
public @interface EnableMyContext {
}
