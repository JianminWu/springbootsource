package com.cdt.dto;

import com.cdt.validation.CRUDGroup;
import com.cdt.validation.PersonExtraValidate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 14:59
 * @Function:
 * @Version 1.0
 */
@Data
public class PersonDto extends BaseDto {

    @Null(groups = {CRUDGroup.CREATE.class})
    @NotNull(groups = {CRUDGroup.UPDATE.class,CRUDGroup.DELETE.class})
    private Long id;

    @NotBlank(message = "name can not be empty")
    @PersonExtraValidate(prefix = "alex")
    private String name;

    @Max(value = 30,message = "age max is 30")
    private Integer age;

    @Email(message = "not a email")
    private String email;

    @Length(max = 20,message = "max length is 20")
    private String address;

}
