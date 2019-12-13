package com.cdt.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:59
 * @Function:
 * @Version 1.0
 */
public class PersonExtraValidator implements ConstraintValidator<PersonExtraValidate,String> {
    private String prefix;

    @Override
    public void initialize(PersonExtraValidate constraintAnnotation) {
        //取出注解中的数据
        this.prefix = constraintAnnotation.prefix();
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //校验规则为：名字必须以#{prefix}开头
        if (!value.startsWith(prefix)){
            /**
             * 自定义校验错误信息
             */
            context.disableDefaultConstraintViolation();
            ConstraintValidatorContext.ConstraintViolationBuilder builder =
                    context.buildConstraintViolationWithTemplate("人的名字必须以\"" + prefix + "\"起始");
            builder.addConstraintViolation();
            return false;
        }
        return true;
    }
}
