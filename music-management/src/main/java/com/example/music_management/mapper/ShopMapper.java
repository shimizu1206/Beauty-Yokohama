package com.example.music_management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Shop;


    @Mapper
public interface ShopMapper {
   @Select("SELECT * FROM shops")
    List<Shop> selectAllShops();

    @Select("SELECT * FROM shops WHERE shop_id = #{shopId}")
    Shop selectShopById(long shopId);

}

