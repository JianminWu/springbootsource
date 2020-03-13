//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resolver.util;


import org.springframework.beans.BeanUtils;

public class SingleResult<T> extends ResultBase {
    private T data;

    public SingleResult() {
    }

    public static <T> SingleResult<T> from(T dto) {
        SingleResult<T> singleResult = new SingleResult();
        singleResult.setData(dto);
        singleResult.setStatus(ResultStatus.SUCCESS);
        return singleResult;
    }

    public static <T, S> SingleResult<S> from(T t, Class<S> clazz, String... ignoreProperties) {
        SingleResult<S> singleResult = new SingleResult();
        if (t != null) {
//            singleResult.setData(BeanCopier.copy(t, clazz, CopyStrategy.IGNORE_NULL, ignoreProperties));
            S s = null;
            try {
                s = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(t,s,ignoreProperties);
            singleResult.setData(s);
        }

        singleResult.setStatus(ResultStatus.SUCCESS);
        return singleResult;
    }

    public T getData() {
        super.getData();
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ViewResult to() {
        return super.to().data(this.data);
    }
}
