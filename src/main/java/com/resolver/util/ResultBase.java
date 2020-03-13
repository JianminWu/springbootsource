//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resolver.util;

import com.alibaba.fastjson.JSON;

public class ResultBase implements Resultable {
    private ResultStatus status;
    private String message;
    private String code;

    public ResultBase() {
        this.status = ResultStatus.SUCCESS;
    }

    public Object getData() {
//        if (this.failure()) {
//            String message = this.getMessage();
//            if (message.contains("dubbo")) {
////                throw new ZDSException("远程调用异常", CommonErrorCode.TECH_ERROR.code());
//            } else {
////                throw new ZDSException(this.getMessage(), this.code());
//            }
//        } else {
//            return null;
//        }
        return null;
    }

    public boolean success() {
        return this.status == ResultStatus.SUCCESS;
    }

    public boolean failure() {
        return this.status == ResultStatus.FAILURE;
    }

    public boolean processing() {
        return this.status == ResultStatus.PROCESSING;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public ViewResult to() {
        ViewResult viewResult = new ViewResult();
        viewResult.setCode(this.code());
        viewResult.setMessage(this.getMessage());
        viewResult.setSuccess(this.success());
        return viewResult;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public ResultStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public void setStatus(final ResultStatus status) {
        this.status = status;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}
