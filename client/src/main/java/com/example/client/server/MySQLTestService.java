package com.example.client.server;


import com.example.client.entity.UserEntity;
import com.example.client.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySQLTestService {

    @Autowired
    private TestMapper testMapper;  //这里会有报错，不用管

    public UserEntity select() {
        return testMapper.select();
    }
}
