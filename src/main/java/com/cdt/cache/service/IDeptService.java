package com.cdt.cache.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdt.cache.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdt.util.QueryRequest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-12
 */
public interface IDeptService extends IService<Dept> {

    Dept updateReturnDto(Dept dept);

    Dept findByName(String name);

    List<Dept> findList(QueryRequest request);

    Page<Dept> findPage(QueryRequest request);
}
