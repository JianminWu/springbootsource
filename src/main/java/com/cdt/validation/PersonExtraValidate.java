package com.cdt.validation;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 16:00
 * @Function:
 * @Version 1.0
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {PersonExtraValidator.class})
public @interface PersonExtraValidate {
    String prefix() default "";
    String message() default "";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
