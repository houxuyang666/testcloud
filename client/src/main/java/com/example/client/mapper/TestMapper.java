package com.example.client.mapper;


import com.example.client.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {


    @Select("select * from user where userid='8'")
    UserEntity select();
}
