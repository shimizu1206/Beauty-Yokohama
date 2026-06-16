package com.example.music_management.mapper;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Kuti;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KutiMapper{
       @Insert("INSERT INTO kutis (age,gender,kansou,#{shopId}) VALUES (#{age}, #{gender}, #{kansou},#{shopId})")
   @Options(useGeneratedKeys = true, keyProperty = "kutiId")
   void insertKutikomi(Kuti kuti);

       @Select("SELECT * FROM items WHERE shop_id = #{shopId}")
    List<Kuti> selectKutisByshopId(long shopId);
}
