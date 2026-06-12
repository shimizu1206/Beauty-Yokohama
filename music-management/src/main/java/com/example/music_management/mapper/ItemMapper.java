package com.example.music_management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Item;

@Mapper
public interface ItemMapper {
   @Select("SELECT * FROM items")
    List<Item> selectAllItems();

    @Select("SELECT * FROM items WHERE item_id = #{itemId}")
    Item selectItemById(long itemId);

    @Select("SELECT * FROM items WHERE shop_id = #{shopId}")
    List<Item> selectItemsByshopId(long shopId);
}
