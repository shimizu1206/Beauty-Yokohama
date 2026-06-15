package com.example.music_management.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Reserve {
    private long reserveId;
    private String shopName;
    private long shopId;
    private String userName;
    private String staffName;
    private String menu;
    private int price;
    private LocalDateTime DateAndTime;
    private String item;
}
