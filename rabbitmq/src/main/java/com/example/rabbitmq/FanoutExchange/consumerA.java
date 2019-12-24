package com.example.rabbitmq.FanoutExchange;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_fanout_A") /*消费者需要监听 并声明监听的队列名称 以便获取消息*/
@Slf4j
public class consumerA {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("consumerA接收消息  : " + hello);
    }
}
