package com.example.music_management.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.music_management.entity.Item;
import com.example.music_management.mapper.ItemMapper;

@Repository
public class ItemRepository {
    private final ItemMapper itemMapper;

    public ItemRepository(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public Item getItemById(long albumId) {
        return itemMapper.selectItemById(albumId);
    }

    public List<Item> getAllItems() {
        return itemMapper.selectAllItems();
    }

    public List<Item> getItemsByshopId(long shopId){
        return itemMapper.selectItemsByshopId(shopId);
    }
}
