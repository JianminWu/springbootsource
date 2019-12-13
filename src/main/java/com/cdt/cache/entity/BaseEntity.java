package com.cdt.cache.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: wujianmin
 * @Date: 2019/12/12 11:39
 * @Function:
 * @Version 1.0
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @TableId(type = IdType.AUTO)
    @Column(name = "id", columnDefinition = "int(19) unsigned NOT NULL COMMENT '主键ID'")
    private Long id;

    @Column(name = "create_time", columnDefinition = " timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    @Column(name = "version", columnDefinition = "int(12) unsigned NOT NULL DEFAULT '0' COMMENT '版本号'")
    @Version
    private Integer version;

}
