package com.example.rabbitmq.Test;

import com.example.rabbitmq.easyMQ.publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class easyMQTest {


    @Autowired
    private publisher publisher;

    @Test
    public void hello() throws Exception {
        publisher.send();
    }
}
