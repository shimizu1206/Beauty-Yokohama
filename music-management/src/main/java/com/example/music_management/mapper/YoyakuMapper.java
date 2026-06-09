package com.example.music_management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Yoyaku;


    @Mapper
public interface YoyakuMapper {
   @Select("SELECT * FROM yoyakus")
    List<Yoyaku> selectAllYoyakus();
}

