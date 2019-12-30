package com.example.redis.controller;


import com.example.redis.Redis.RedisUtils;
import com.example.redis.entity.MusicEntity;
import com.example.redis.server.MySQLTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MySQLTestController {


    @Autowired
    private MySQLTestService mySQLTestService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * @author Hou.xy
     * @Param: musicid
     * @return java.lang.Object
     * @create 2019/12/30
     * @description 功能描述
     */
    @GetMapping("/select")
    public Object select(int musicid,String aaa) throws Exception {
        if (redisUtils.exists("music")){
            log.info("Redis取出{}成功","music");
            return redisUtils.get("music");
        }
        MusicEntity music =mySQLTestService.select(musicid);
        int random =RandomUtils.nextInt(10)*10;
        redisUtils.save("music",music, random);
        System.out.println(aaa);
        log.info("Redis存入{}成功，缓存时间为{}秒","music",random);
        return music;
    }





}
