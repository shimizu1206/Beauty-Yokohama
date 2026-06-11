package com.example.music_management.entity;
import lombok.Data;

@Data
public class Shop {
    private long shopId;
    private String shopName;
    private long openingHours;
    private String shopAddress;
    private String priceRange;
}
