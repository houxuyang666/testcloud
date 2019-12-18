package com.example.feign.controller;

import com.example.feign.fegin.Feignservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class feginController {

        @Autowired
        private Feignservice feignService;

        //请求路径 通过路径请求找到该方法 该方法调用feignService接口
        @RequestMapping("/home")
        String home(@RequestParam String name) {
            return feignService.goHome(name);
        }


        @RequestMapping("/index")
        String index() {
                return feignService.index();
        }

}
