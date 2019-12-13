package com.cdt.annotation;

//import com.cdt.autoconfig.CustomEnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

//@Inherited
//@Documented
//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@Import(CustomEnableAutoConfiguration.class)
//public @interface EnableRedis { //相当于使用定义spring.factories完成Bean的自动装配
//    //spring.factories 在这里配置，只要引用jar就加载到
//    //@Import(RedisAutoConfiguration.class) 需要在调用者的Main 类加上该注解就能等效于spring.factories 文件配置
//}