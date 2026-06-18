package com.example.music_management.form;

import lombok.Data;

@Data
public class StaffView{
    private long shopId;
    private String shopName;
    private String openingHours;
    private String shopAddress;
    private String priceRange;
    private String staffCount;
    private String kutisCount;
    private String picture;
}
