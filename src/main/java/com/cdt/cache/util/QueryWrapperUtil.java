package com.cdt.cache.util;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdt.util.QueryRequest;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: wujianmin
 * @Date: 2019/12/18 17:19
 * @Function:
 * @Version 1.0
 */
public class QueryWrapperUtil {
    public static Page pharsePage(QueryRequest request) {
        Page page = new Page<>();
        page.setSize(request.getPageInfo().getSize());
        page.setPages(request.getPageInfo().getPage());
        return page;
    }

    public static QueryWrapper pharseWrapper(QueryRequest request) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        request.getQuery().getMust().forEach(t -> {
            String filed = t.getFiled();
            Object value = t.getValue();
            switch (t.getOperator()) {
                case EQ:
                    queryWrapper.eq(filed, value);
                    break;
                case LIKE:
                    queryWrapper.like(filed, value);
                    break;
                case LLIKE:
                    queryWrapper.likeLeft(filed, value);
                    break;
                case RLIKE:
                    queryWrapper.likeRight(filed, value);
                    break;
                case IN:
                    queryWrapper.in(filed, ((JSONArray) value).toJavaList(String.class));
                    break;
                case NOTIN:
                    queryWrapper.notIn(filed, ((JSONArray) value).toJavaList(String.class));
                    break;
                case GT:
                    queryWrapper.gt(filed, value);
                    break;
                case LT:
                    queryWrapper.lt(filed, value);
                    break;
                case GTE:
                    queryWrapper.ge(filed, value);
                    break;
                case LTE:
                    queryWrapper.le(filed, value);
                    break;
                case NULL:
                    queryWrapper.isNull(filed);
                case NOTNULL:
                    queryWrapper.isNotNull(filed);
            }
        });

        List<String> asc = request.getSorts().stream().filter(t -> QueryRequest.Direction.ASC == t.getDirection()).map(QueryRequest.Sort::getName).collect(toList());
        queryWrapper.orderByAsc(asc.toArray(new String[asc.size()]));
        List<String> desc = request.getSorts().stream().filter(t -> QueryRequest.Direction.DESC == t.getDirection()).map(QueryRequest.Sort::getName).collect(toList());
        queryWrapper.orderByDesc(desc.toArray(new String[desc.size()]));
        return queryWrapper;
    }
}
