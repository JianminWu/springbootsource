package com.cdt.cache.service;

import com.cdt.cache.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.io.Serializable;

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
}
