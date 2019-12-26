package com.example.redis.entity;


import lombok.Data;

import java.io.Serializable;
@Data
public class MusicEntity implements Serializable {

    private int musicid;
    private String musicname;
    private String musictype;
    private String musicurl;
}
