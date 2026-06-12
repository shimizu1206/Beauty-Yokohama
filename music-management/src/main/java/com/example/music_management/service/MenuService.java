package com.example.music_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.music_management.entity.Menu;
import com.example.music_management.repository.MenuRepository;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository){ //リポに届ける
        this.menuRepository = menuRepository;
    }
        public List<Menu> getAllMenus(){//htmlに届ける
        return menuRepository.getAllMenus();
    }
    public Menu getMenuById(long albumId) {//htmlに届ける
        return menuRepository.getMenuById(albumId);
    }

      public List<Menu> getMenusByshopId(long shopId){
        return menuRepository.getMenusByshopId(shopId);
    }
}