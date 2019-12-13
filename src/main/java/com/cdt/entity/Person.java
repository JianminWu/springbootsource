package com.cdt.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:17
 * @Function:
 * @Version 1.0
 */
@Data
@Entity
@Table(name="person")
public class Person extends BaseEntity{
    @Id    //主键id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//主键生成策略
    @Column(name="id")//数据库字段名
    private Long id ;

    @Column(name = "name", columnDefinition = "varchar(100) NOT NULL COLLATE utf8_bin comment 'name'")
    private String name;

    @Column(name = "age", columnDefinition = "int(4) NOT NULL COLLATE utf8_bin comment 'age'")
    private Integer age;

    @Column(name = "email", columnDefinition = "varchar(100) COLLATE utf8_bin comment 'email'")
    private String email;

    @Column(name = "address", columnDefinition = "varchar(100) COLLATE utf8_bin comment 'address'")
    private String address;

}
