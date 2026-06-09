package com.example.music_management.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.music_management.entity.Yoyaku;
import com.example.music_management.mapper.YoyakuMapper;

@Repository
public class YoyakuRepository {
    private final YoyakuMapper yoyakuMapper;
    public YoyakuRepository(YoyakuMapper yoyakuMapper){
        this.yoyakuMapper = yoyakuMapper;
    }

        public List<Yoyaku> getAllYoyakus(){
        return yoyakuMapper.selectAllYoyakus();
    }
}
