//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resolver.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;

public class ListResult<T> extends ResultBase {
    private List<T> data;

    public ListResult() {
    }

    public static <T> ListResult<T> from(List<T> list) {
        ListResult<T> result = new ListResult();
        result.setData(list);
        result.setStatus(ResultStatus.SUCCESS);
        return result;
    }

    public static <T, S> ListResult<S> from(List<T> list, Class<S> clazz, String... ignoreProperties) {
        ListResult<S> result = new ListResult();
        if (list != null && !list.isEmpty()) {
            List<S> sList = Lists.newArrayListWithCapacity(list.size());
            list.forEach(t->{
                S s = null;
                try {
                    s = clazz.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                BeanUtils.copyProperties(t,s,ignoreProperties);
                sList.add(s);
            });
            result.setData(sList);
        } else {
            result.setData(Collections.emptyList());
        }

        result.setStatus(ResultStatus.SUCCESS);
        return result;
    }

    public List<T> getData() {
        super.getData();
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public ViewResult to() {
        return super.to().data(this.data);
    }
}
