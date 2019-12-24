package com.example.rabbitmq.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    /*Topic 主题模式*/

    final  static  String message ="q_topic_message";
    final  static  String messages ="q_topic_messages";
    /*创建两个队列*/


    @Bean
    public Queue queueMessage(){
            return new Queue(TopicRabbitConfig.message,true);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messages,true);
    }

    /*声明这是一个topic类型的交换机*/
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("mybootexchange");
    }

    /*绑定Q到交换机 并制定routing-key*/
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
