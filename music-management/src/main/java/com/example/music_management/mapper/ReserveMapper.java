package com.example.music_management.mapper;

import com.example.music_management.entity.Reserve;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Options;

@Mapper
public interface ReserveMapper {

    @Insert("INSERT INTO menus (shop_name,user_name,staff_name,menu,price,Date_and_Time,item) VALUES (#{shopName}, #{userName}, #{staffName}, #{menu}, #{price}, #{DateAndTime}, #{item})")
    @Options(useGeneratedKeys = true, keyProperty = "reserveId")
    void insertReserve(Reserve reserve); // 新規作成

}
