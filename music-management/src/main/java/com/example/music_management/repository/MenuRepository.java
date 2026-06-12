package com.example.music_management.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.music_management.entity.Menu;
import com.example.music_management.mapper.MenuMapper;

@Repository
public class MenuRepository {
    private final MenuMapper menuMapper;

    public MenuRepository(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public Menu getMenuById(long albumId) {
        return menuMapper.selectMenuById(albumId);
    }

    public List<Menu> getAllMenus() {
        return menuMapper.selectAllMenus();
    }

    public List<Menu> getMenusByshopId(long shopId){
        return menuMapper.selectMenusByshopId(shopId);
    }
}
