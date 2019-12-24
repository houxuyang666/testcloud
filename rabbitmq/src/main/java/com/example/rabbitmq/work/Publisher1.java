package com.example.rabbitmq.work;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/*把普通pojo实例化到spring容器中*/
@Component
@Slf4j
public class Publisher1 {/*生产者*/

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i){
        String  date =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); //获取当前时间
        String  Message ="Hello    "+i+"    "+date;
        //work队列的情况下 routinkey即为Q名   跟简单队列没有什么特别大的区别 主要在于他有两个消费者 所以 两个消费者会分摊生产者发送的多条信息
        this.rabbitTemplate.convertAndSend("test_queue2",Message);
        log.info("发送消息   "+Message+"   成功");
    }

}
