package com.example.rabbitmq.Config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    /*订阅模式或广播模式  只要监听了该队列的所有消费者都可以收到信息*/

    /*创建三个队列*/
    @Bean
    public Queue aMessage(){
        return new Queue("q_fanout_A");
    }
    @Bean
    public Queue bMessage(){
        return new Queue("q_fanout_B");
    }
    @Bean
    public Queue cMessage(){
        return new Queue("q_fanout_C");
    }

    /*创建交换器*/
    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    /*将三个队列绑定到该交换器*/
    @Bean
    Binding bindingExchangeA(Queue aMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(aMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeB(Queue bMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bMessage).to(fanoutExchange);
    }
    @Bean
    Binding bindingExchangeb(Queue cMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(cMessage).to(fanoutExchange);
    }
}
