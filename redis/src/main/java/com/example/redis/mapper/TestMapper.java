package com.example.redis.mapper;


import com.example.redis.entity.MusicEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestMapper {


    @Select("select * from music where musicid=#{musicid}")
    MusicEntity select(@Param("musicid")int musicid);
}
