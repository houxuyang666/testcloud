package com.example.rabbitmq.Test;

import com.example.rabbitmq.TopicExchange.TopicPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TopicTest {


    @Autowired
    private TopicPublisher topicPublisher;

    @Test
    public void send1() throws Exception {
        topicPublisher.send1();
    }

    @Test
    public void send2() throws Exception {
        topicPublisher.send2();
    }
}
