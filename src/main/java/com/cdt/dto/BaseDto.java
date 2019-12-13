package com.cdt.dto;

import org.springframework.beans.BeanUtils;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:26
 * @Function:
 * @Version 1.0
 */
public class BaseDto {

    public <T> T to(Class<T> clazz) {
        try {
            T instance = clazz.newInstance();
            BeanUtils.copyProperties(this, instance);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
