package com.example.redis.server;


import com.example.redis.entity.MusicEntity;
import com.example.redis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLTestService {

    @Autowired
    private TestMapper testMapper;  //这里会有报错，不用管

    public MusicEntity select(int musicid) {
        return testMapper.select(musicid);
    }
}
