package com.example.music_management.entity;

import lombok.Data;

@Data
public class Menu {
    private long menuId;
    private String menu;
    private int price;
    private String cutTime;
    private String menuMessage;
}
