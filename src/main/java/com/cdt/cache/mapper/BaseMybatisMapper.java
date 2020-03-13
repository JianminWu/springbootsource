package com.cdt.cache.mapper;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdt.cache.util.QueryWrapperUtil;
import com.cdt.util.QueryRequest;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: wujianmin
 * @Date: 2019/12/18 15:01
 * @Function:
 * @Version 1.0
 */
public interface BaseMybatisMapper<T> extends BaseMapper<T> {

    default List<T> findAll(QueryRequest request) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.pharseWrapper(request);
        return this.selectList(queryWrapper);
    }

    default Page<T> findPage(QueryRequest request) {
        QueryWrapper<T> queryWrapper = QueryWrapperUtil.pharseWrapper(request);
        Page<T> page = QueryWrapperUtil.pharsePage(request);
        return (Page<T>)this.selectPage(page, queryWrapper);
    }

}
