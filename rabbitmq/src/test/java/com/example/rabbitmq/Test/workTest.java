package com.example.rabbitmq.Test;

import com.example.rabbitmq.work.Publisher1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class workTest {


    @Autowired
    private Publisher1 publisher;

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<10;i++){
            publisher.send(i);
            //Thread.sleep(300);
        }
    }

}
