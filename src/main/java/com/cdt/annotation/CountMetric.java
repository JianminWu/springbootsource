package com.cdt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: wujianmin
 * @Date: 2019/11/12 16:11
 * @Function:
 * @Version 1.0
 */

@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountMetric {
}
