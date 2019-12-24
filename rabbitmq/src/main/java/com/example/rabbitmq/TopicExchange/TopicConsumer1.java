package com.example.rabbitmq.TopicExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
@RabbitListener(queues = "q_topic_message") /*消费者需要监听 并声明监听的队列名称 以便获取消息*/
@Slf4j
public class TopicConsumer1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
        log.info("Tpoic1接受消息" + hello + "成功");
    }

}
