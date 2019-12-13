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
public class RabbitMQTopicConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic.exchange");
    }

    @Bean
    public Binding topicABinding(TopicExchange topicExchange,Queue topicAAQueue) {
        return  BindingBuilder.bind(topicAAQueue).to(topicExchange).with("topic.A.#");
    }

    @Bean
    public Binding topicAllBinding(TopicExchange topicExchange,Queue topicAQueue) {
        return  BindingBuilder.bind(topicAQueue).to(topicExchange).with("topic.#");
    }

    @Bean
    public Binding topicBBinding(TopicExchange topicExchange, Queue topicBQueue) {
        return BindingBuilder.bind(topicBQueue).to(topicExchange).with("topic.B");
    }

}
