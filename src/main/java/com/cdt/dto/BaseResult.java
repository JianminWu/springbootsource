package com.cdt.dto;

import lombok.Data;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:03
 * @Function:
 * @Version 1.0
 */
@Data
public class BaseResult {

    private String msg = "success";

    private Object data;

    public BaseResult(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(Object data) {
        this.data = data;
    }
}
