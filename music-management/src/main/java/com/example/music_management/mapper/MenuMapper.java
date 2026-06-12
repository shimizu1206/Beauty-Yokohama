package com.example.music_management.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.music_management.entity.Menu;

@Mapper
public interface MenuMapper {
   @Select("SELECT * FROM menus")
    List<Menu> selectAllMenus();

    @Select("SELECT * FROM menus WHERE menu_id = #{menuId}")
    Menu selectMenuById(long menuId);
}
