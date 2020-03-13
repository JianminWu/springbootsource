package com.cdt.cache.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdt.cache.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-12
 */
public interface DeptMapper extends BaseMybatisMapper<Dept> {

    Integer findVersion(@Param("dept") Dept dept);

}
