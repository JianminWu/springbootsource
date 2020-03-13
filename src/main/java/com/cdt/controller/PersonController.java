package com.cdt.controller;

import com.alibaba.fastjson.JSON;
import com.cdt.annotation.CountMetric;
import com.cdt.autoconfig.MyContextConfig;
import com.cdt.dto.BaseResult;
import com.cdt.dto.PersonDto;
import com.cdt.service.PersonService;
import com.cdt.util.QueryRequest;
import com.cdt.validation.CRUDGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:03
 * @Function:
 * @Version 1.0
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/find/{id}")
    @CountMetric
    public BaseResult findById(@PathVariable("id") Long id) {
        return new BaseResult(personService.findById(id));
    }

    @GetMapping("/find2/{id}")
    public BaseResult findById2(@PathVariable("id") Long id) {
        return new BaseResult(personService.findById(id));
    }


    @PostMapping("/create")
    public BaseResult create(@RequestBody @Validated(CRUDGroup.CREATE.class) PersonDto personDto) {
        return new BaseResult(personService.create(personDto));
    }

    @PostMapping("/update")
    public BaseResult update(@RequestBody @Validated(CRUDGroup.UPDATE.class) PersonDto personDto) {
        return new BaseResult(personService.update(personDto));
    }

    // 测试自动springboot 自动配置功能
    @Autowired
    MyContextConfig contextConfig;

    @GetMapping("/test1")
    public BaseResult test1(QueryRequest queryRequest) {
        System.out.println(JSON.toJSONString(queryRequest));
        return new BaseResult(contextConfig);
    }
}
