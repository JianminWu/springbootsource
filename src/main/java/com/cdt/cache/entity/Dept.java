package com.cdt.cache.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: wujianmin
 * @Date: 2019/12/12 11:41
 * @Function:
 * @Version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept extends BaseEntity {

    @Column(name = "name", columnDefinition = "varchar(30) COMMENT 'name'")
    private String name;

    @Column(name = "tel", columnDefinition = "varchar(30) COMMENT 'tel'")
    private String tel;

    @Column(name = "display_name", columnDefinition = "varchar(30) COMMENT 'display_name'")
    private String displayName;

}
