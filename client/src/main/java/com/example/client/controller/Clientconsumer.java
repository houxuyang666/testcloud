package com.example.client.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component  /*一定要注入 */
@RabbitListener(queues = "test_queue") /*消费者需要监听 并声明监听的队列名称 以便获取消息（只要监听的消息队列有消息 那么该类就可以自动执行）*/
@Slf4j
public class Clientconsumer {
    /*与rabbitmq下easyMQ测试成功*/
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
        log.info("clientconsumer接受消息"+hello+"成功");
    }
}
