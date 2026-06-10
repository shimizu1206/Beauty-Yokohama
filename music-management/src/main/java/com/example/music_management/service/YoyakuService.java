package com.example.music_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.music_management.entity.Yoyaku;
import com.example.music_management.repository.YoyakuRepository;

@Service
public class YoyakuService {
    private final YoyakuRepository yoyakuRepository;

    public YoyakuService(YoyakuRepository yoyakuRepository){
        this.yoyakuRepository = yoyakuRepository;
    }
        public List<Yoyaku> getAllYoyakus(){
        return yoyakuRepository.getAllYoyakus();
    }
    public Yoyaku getAlbumById(long albumId) {
        return yoyakuRepository.getYoyakuById(albumId);
    }
}
