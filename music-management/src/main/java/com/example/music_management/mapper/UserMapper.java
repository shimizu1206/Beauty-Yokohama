package com.example.music_management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.User;


    @Mapper
public interface UserMapper {
    @Select("SELECT user_id, username, password, user_address, user_check ,created_at FROM users WHERE username = #{username}")
    User selectUserByUsername(String username);

    @Insert("INSERT INTO users (username, password,user_address,user_check) VALUES (#{username}, #{password},#{userAddress},#{userCheck})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    void insertUser(User user);
}

