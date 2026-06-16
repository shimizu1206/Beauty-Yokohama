package com.example.music_management.mapper;

import com.example.music_management.entity.Reserve;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReserveMapper {

    @Insert("INSERT INTO reserve (shop_name,user_name,staff_name,menu,price,Date_and_Time,item,shop_id) VALUES (#{shopName}, #{userName}, #{staffName}, #{menu}, #{price}, #{DateAndTime}, #{item},#{shopId})")
    @Options(useGeneratedKeys = true, keyProperty = "reserveId")
    void insertReserve(Reserve reserve); // 新規作成


    @Select("SELECT * FROM reserve") //
    List<Reserve> selectreserveById();
}

