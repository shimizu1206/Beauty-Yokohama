package com.example.music_management.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Album {
    private long albumId;
    private String title;
    private String artist;
    private String releaseDate;
    private LocalDateTime createdAt;
}