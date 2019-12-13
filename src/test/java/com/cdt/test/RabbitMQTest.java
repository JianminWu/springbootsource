package com.cdt.test;

import com.cdt.cache.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wujianmin
 * @Date: 2019/12/13 16:59
 * @Function:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest()// 指定启动类
public class RabbitMQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMsg() {
        rabbitTemplate.convertAndSend("direct.exchange", "/dept", "32131");
    }

    @Test
    public void testSendFanoutMsg() {
        rabbitTemplate.convertAndSend("fanout.exchange", "", "6666");
    }

    @Test
    public void testSendTopicMsg(){
        rabbitTemplate.convertAndSend("topic.exchange","topic.B","BBB");
    }
}
