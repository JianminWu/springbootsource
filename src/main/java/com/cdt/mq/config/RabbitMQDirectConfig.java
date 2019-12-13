package com.cdt.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wujianmin
 * @Date: 2019/12/13 16:47
 * @Function:
 * @Version 1.0
 */
@Configuration
public class RabbitMQDirectConfig {

    @Bean
    public Exchange directExchange() {
        return new DirectExchange("direct.exchange");
    }

//    @Bean
//    public Exchange topicExchange() {
//        return new FanoutExchange("topic.exchange");
//    }

    @Bean
    public Binding deptBinding(Exchange directExchange, Queue deptQueue) {
        return BindingBuilder.bind(deptQueue).to(directExchange).with("/dept").noargs();
    }

    @Bean
    public Binding personBinding(Exchange directExchange, Queue deptQueue) {
        return BindingBuilder.bind(deptQueue).to(directExchange).with("/person").noargs();
    }

}
