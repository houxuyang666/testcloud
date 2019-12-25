package com.example.rabbitmq.TopicExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "topic_2") /*消费者需要监听 并声明监听的队列名称 以便获取消息*/
@Slf4j
public class TopicConsumer2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello+"   我监听的是topic_2");
    }

}
