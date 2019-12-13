package com.cdt.cache.controller;


import com.cdt.cache.entity.Dept;
import com.cdt.cache.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-12
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @GetMapping("/{id}")
    private Dept findById(@PathVariable(value = "id") Long id) {
        return deptService.getById(id);
    }

    @PostMapping()
    private Dept create(@RequestBody Dept dept) {
        deptService.save(dept);
        return dept;
    }

    @PutMapping
    private Dept update(@RequestBody Dept dept) {
        return deptService.updateReturnDto(dept);
    }


    @DeleteMapping("{id}")
    private void delete(@PathVariable("id") Long id) {
        deptService.removeById(id);
    }
}
