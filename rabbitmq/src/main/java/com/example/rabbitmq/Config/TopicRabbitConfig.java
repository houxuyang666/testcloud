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

    final  static  String message ="topic_1";
    final  static  String messages ="topic_2";
    final  static  String topicExchange ="mybootexchange";
    /*创建两个队列*/


    @Bean
    public Queue queue1(){
            return new Queue(message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messages);
    }

    /*声明这是一个topic类型的交换机*/
    @Bean
    TopicExchange exchange(){
            return new TopicExchange(topicExchange);
    }

    /*设置routing-key（路由键   通配符 #为任意单词  * 为一个单词 以.分割  去和生产者发送消息时的routingkey进行匹配 ）*/

    /*绑定Q到交换机 并制定routing-key*/
    @Bean
    Binding bindingExchange() {
        return BindingBuilder.bind(queue1()).to(exchange()).with("topic.qqq");
    }

    @Bean
    Binding bindingExchangeMessages() {
        return BindingBuilder.bind(queueMessages()).to(exchange()).with("topic.#");
    }

}
