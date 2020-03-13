package com.cdt.cache.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdt.cache.entity.Dept;
import com.cdt.cache.mapper.DeptMapper;
import com.cdt.cache.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdt.util.QueryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

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

    @Cacheable(key = "#serializable", unless = "#result == null ")
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

    @Override
    public Dept findByName(String name) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Dept::getDisplayName, "213");
        IPage<Dept> page = new Page<>();
        IPage<Dept> deptIPage = deptMapper.selectPage(page, wrapper);
        return deptMapper.selectOne(wrapper);
    }

    @Override
    public List<Dept> findList(QueryRequest request) {
        return deptMapper.findAll(request);
    }

    @Override
    public Page<Dept> findPage(QueryRequest request) {
        return deptMapper.findPage(request);
    }
}
