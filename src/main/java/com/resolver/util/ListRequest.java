//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.resolver.util;

import com.google.common.collect.Maps;
import org.springframework.data.domain.Sort;

import java.util.Map;

public class ListRequest<T> extends SingleRequest<T> {
    private Map<String, Object> map;
    private Sort sort;

    public ListRequest() {
    }

    public static <T> ListRequest<T> from(T data) {
        ListRequest<T> order = new ListRequest();
        order.setData(data);
        return order;
    }

    public static ListRequest<Null> from() {
        ListRequest<Null> order = new ListRequest();
        order.setData(Null.INSTANCE);
        return order;
    }

    public ListRequest<T> map(String key, Object value) {
        if (this.map == null) {
            this.map = Maps.newHashMap();
        }

        this.map.put(key, value);
        return this;
    }

    public ListRequest<T> sort(Sort sort) {
        this.sort = sort;
        return this;
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public Sort getSort() {
        return this.sort;
    }

    public void setMap(final Map<String, Object> map) {
        this.map = map;
    }

    public void setSort(final Sort sort) {
        this.sort = sort;
    }
}
