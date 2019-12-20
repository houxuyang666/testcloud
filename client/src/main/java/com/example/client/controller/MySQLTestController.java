package com.example.client.controller;


import com.example.client.entity.UserEntity;
import com.example.client.server.MySQLTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySQLTestController {

    @Value("${server.port}")
    String port;


    @Autowired
    private MySQLTestService mySQLTestService;

    @GetMapping("/select")
    public String select() throws Exception {

        UserEntity user =mySQLTestService.select();
        return user.getName()+","+user.getUsername();
    }


    @RequestMapping("/home")
    public String toHome(@RequestParam String name) {
        return "hi, "+name+" i an come from"+port;
    }



    @RequestMapping("/hi")
    public String hi() {

        return "hi";
    }

}
