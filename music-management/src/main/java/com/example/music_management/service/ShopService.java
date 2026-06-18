package com.example.music_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.music_management.entity.Shop;
import com.example.music_management.form.StaffView;
import com.example.music_management.repository.ShopRepository;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }
        public List<StaffView> getAllShops(){
        return shopRepository.getAllShops();
    }
    public Shop getShopById(long shopId) {
        return shopRepository.getShopById(shopId);
    }
}
