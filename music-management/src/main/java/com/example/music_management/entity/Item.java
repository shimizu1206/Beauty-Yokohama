package com.example.music_management.entity;

import lombok.Data;

@Data
public class Item {
    private long itemId;
    private String itemName;
    private int price;
    private String features;
    private long shop_id;
    private String picture;
}
