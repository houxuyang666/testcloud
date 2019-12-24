package com.example.rabbitmq.Controller;


import com.example.rabbitmq.easyMQ.publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumerController {


    @Autowired
    private publisher publisher;

    @RequestMapping("/cs")
    public void cs(String hello) {
        publisher.send();
    }
}
