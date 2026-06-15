package com.example.music_management.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class ReserveForm {
    private String shopName;
    private long shopId;
    private String userName;
    private String staffName;
    private String menu;
    private int price;
    private LocalDateTime DateAndTime;
    private String item;
}
