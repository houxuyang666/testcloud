package com.example.rabbitmq.Test;

import com.example.rabbitmq.FanoutExchange.FanoutPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FanoutTest {


    @Autowired
    private FanoutPublisher fanoutPublisher;

    @Test
    public void send() throws Exception {
        fanoutPublisher.send();
    }

}


