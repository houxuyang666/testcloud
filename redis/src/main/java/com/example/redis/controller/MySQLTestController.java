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
     * @Param: id
     * @return java.lang.Object
     * @create 2019/12/30
     * @description 实现查询插入缓存并防止缓存穿透
     */
    @GetMapping("/select")
    public Object select(int id) throws Exception {
        /*根据查询的id 设置唯一的键*/
        String musickey=String.valueOf(id);
        /*参数是否合法*/
        if(id>0&&id<1000000){
            /*如果缓存有该键 获取后直接返回*/
            if (redisUtils.exists(musickey)){
                log.info("Redis取出{}成功",musickey);
                return redisUtils.get(musickey);
            }
        }else{
            return "参数不合法";
        }
        /*如果没有就查询DB*/
        MusicEntity music =mySQLTestService.select(id);
        /*如果查询后为空值  为了防止恶意攻击 我们将new一个空对象 并设置一个较短的失效时间返回*/
        if (music==null){
            /*设置一个随机的失效时间*/
            int random =RandomUtils.nextInt(10)*2;
            /*并存到缓存中*/
            redisUtils.save(musickey,new MusicEntity(), random);
            log.info("Redis存入空对象成功，缓存时间为{}秒",musickey,random);
            return redisUtils.get(musickey);
        }
        /*并存到缓存中*/
        redisUtils.save(musickey,music, 30);
        log.info("Redis存入{}成功，缓存时间为{}秒",musickey,30);
        return music;
    }





}
