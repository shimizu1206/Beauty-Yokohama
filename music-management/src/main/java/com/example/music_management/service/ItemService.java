package com.example.music_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.music_management.entity.Item;
import com.example.music_management.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){ //リポに届ける
        this.itemRepository = itemRepository;
    }
        public List<Item> getAllItems(){//htmlに届ける
        return itemRepository.getAllItems();
    }
    public Item getItemById(long albumId) {//htmlに届ける
        return itemRepository.getItemById(albumId);
    }

    public List<Item> getItemsByshopId(long shopId){
        return itemRepository.getItemsByshopId(shopId);
    }
}
