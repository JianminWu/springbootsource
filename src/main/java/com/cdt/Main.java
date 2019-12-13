package com.cdt;

import com.cdt.autoconfig.EnableMyContext;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:00
 * @Function:
 * @Version 1.0
 */
@SpringBootApplication
@EnableMyContext
@EnableCaching
@MapperScan(basePackages = {"com.cdt.cache.mapper"})
@Slf4j
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
//        String result = context.getEnvironment().getProperty("spring.datasource.password");
////        CustomConfig customConfig = context.getBean(CustomConfig.class);
////        System.out.println(customConfig);
////        MyContextConfig customConfig = context.getBean(MyContextConfig.class);
//        System.out.println(result);
    }
}
