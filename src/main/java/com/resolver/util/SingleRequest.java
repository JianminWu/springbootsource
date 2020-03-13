//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resolver.util;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SingleRequest<T> extends RequestBase {
    @Valid
    @NotNull
    private T data;

    public SingleRequest() {
    }

    public static <T> SingleRequest<T> from(T dto) {
        SingleRequest<T> order = new SingleRequest();
        order.setData(dto);
        return order;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
