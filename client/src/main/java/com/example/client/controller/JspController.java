package com.example.client.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class JspController {

    @RequestMapping("/index")
    public String index() {
        log.info("进入index");

        return "index";
    }


}
