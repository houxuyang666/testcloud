package com.example.rabbitmq.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    /*普通模式和work都可用*/

    @Bean
    public Queue queue(){
        return new Queue("test_queue");
    }

    @Bean
    public Queue queue2(){
        return new Queue("test_queue2");
    }
}
