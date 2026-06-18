package com.example.music_management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Shop;
import com.example.music_management.form.StaffView;


    @Mapper
public interface ShopMapper {
   @Select(""" 
    SELECT s.shop_id, s.shop_name,s.shop_name,s.opening_hours,s.shop_address,s.price_range,s.picture,COUNT(Distinct st.staff_id) AS staff_count,COUNT(Distinct k.kuti_id) AS kutis_count,ROUND(AVG(DISTINCT k.evaluate), 1) AS review_average
    FROM shops s LEFT JOIN staff st ON s.shop_id = st.shop_id 
    LEFT JOIN kutis k ON s.shop_id = k.shop_id 
    GROUP BY s.shop_id
    """)
    List<StaffView> selectAllShops();

    @Select("SELECT * FROM shops WHERE shop_id = #{shopId}")
    Shop selectShopById(long shopId);

}

