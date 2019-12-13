package com.cdt.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wujianmin
 * @Date: 2019/12/13 17:36
 * @Function:
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "topic.A")
public class DirectListener {

    @RabbitHandler
    public void handler(String msg){
        System.out.println(msg);
    }
}
