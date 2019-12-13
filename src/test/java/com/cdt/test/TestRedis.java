package com.cdt.test;

import com.cdt.cache.entity.Dept;
import com.cdt.cache.mapper.DeptMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujianmin
 * @Date: 2019/12/13 11:41
 * @Function:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest()// 指定启动类
public class TestRedis {
    @Autowired
    private RedisTemplate<String, Object> template;

    @Test
    public void testJsonSerializer() {
        Dept build = Dept.builder().name("123").tel("321").build();
        System.out.println(build);
        template.opsForValue().set("123", build);
        Object o = template.opsForValue().get("123");
        System.out.println(o);
//        Dept dept = mapper.selectById(1L);
    }
}