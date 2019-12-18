package com.example.feign.fegin;


import com.example.feign.feiginimpl.Feignserviceimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-client",fallback = Feignserviceimpl.class)  /*配置一个需要调用的客户端的名称 并设置一个熔断类 */
public interface Feignservice {
    /*熔断 需要实现该接口 并且方法名与其一致可以实现方法的熔断*/

    /*service-client 和@RequestMapping("/home") 组成了一个全新的路径 所以就会直接去service-client 里面找home的这个方法*/
    @RequestMapping("/home")
    String goHome(@RequestParam String name);

    @RequestMapping("/index")
    String index();
}
