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
public class RabbitMQFanoutConfig {
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.exchange");
    }


    @Bean
    public Binding deptFanoutBinding(FanoutExchange fanoutExchange, Queue deptQueue) {
        return BindingBuilder.bind(deptQueue).to(fanoutExchange);
    }

    @Bean
    public Binding personFanoutBinding(FanoutExchange fanoutExchange, Queue personQueue) {
        return BindingBuilder.bind(personQueue).to(fanoutExchange);
    }
}
