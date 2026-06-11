package com.example.music_management.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.music_management.entity.Shop;
import com.example.music_management.mapper.ShopMapper;

@Repository
public class ShopRepository {
    private final ShopMapper shopMapper;
    public ShopRepository(ShopMapper yoyakuMapper){
        this.shopMapper = yoyakuMapper;
    }

      public Shop getShopById(long albumId) {
        return shopMapper.selectShopById(albumId);
    }
        public List<Shop> getAllShops(){
        return shopMapper.selectAllShops();
    }
}
