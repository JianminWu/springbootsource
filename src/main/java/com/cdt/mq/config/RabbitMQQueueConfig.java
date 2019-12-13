package com.cdt.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: wujianmin
 * @Date: 2019/12/13 17:17
 * @Function:
 * @Version 1.0
 */
@Configuration
public class RabbitMQQueueConfig {
    @Bean
    public Queue deptQueue() {
        return new Queue("dept", true);
    }

    @Bean
    public Queue personQueue() {
        return new Queue("person", true);
    }

    @Bean
    public Queue topicAQueue() {
        return new Queue("topic.A", true);
    }

    @Bean
    public Queue topicAAQueue() {
        return new Queue("topic.AA", true);
    }

    @Bean
    public Queue topicBQueue() {
        return new Queue("topic.B", true);
    }
}
