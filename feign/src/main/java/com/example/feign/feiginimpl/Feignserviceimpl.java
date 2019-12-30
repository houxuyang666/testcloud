package com.example.feign.feiginimpl;

import com.example.feign.fegin.Feignservice;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


@Component  /*把普通pojo实例化到spring容器*/
public class Feignserviceimpl  implements Feignservice {

    @Override
    public String goHome(@RequestParam String name) {
        return "sorry"+name+" error";
    }

    @Override
    public String index() {
        return "sorry,页面离家出走了";
    }

    @Override
    public String test() {
            return "sorry,页面离家出走了";
    }
}
