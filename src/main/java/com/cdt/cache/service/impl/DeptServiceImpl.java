package com.cdt.cache.service.impl;

import com.cdt.cache.entity.Dept;
import com.cdt.cache.mapper.DeptMapper;
import com.cdt.cache.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-12
 */
@CacheConfig(cacheNames = "dept")
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Cacheable(key = "#serializable",  unless = "#result == null ")
    @Override
    public Dept getById(Serializable serializable) {
        return super.getById(serializable);
    }


    @CachePut(key = "#dept.id")
    public Dept updateReturnDto(Dept dept) {
        return super.updateById(dept) ? this.getById(dept.getId()) : null;
    }

    @CacheEvict(key = "#serializable")
    @Override
    public boolean removeById(Serializable serializable) {
        return super.removeById(serializable);
    }

}
