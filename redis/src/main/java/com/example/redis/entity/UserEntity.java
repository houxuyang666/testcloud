package com.example.redis.entity;

import lombok.Data;

@Data
public class UserEntity {

    private int id;

    private String username;
    private String password;
    private String name;
    private String state;

}
