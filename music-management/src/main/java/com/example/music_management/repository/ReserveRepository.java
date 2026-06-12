package com.example.music_management.repository;

import com.example.music_management.mapper.ReserveMapper;

import com.example.music_management.entity.Reserve;
import org.springframework.stereotype.Repository;

public class ReserveRepository {
    private final ReserveMapper reserveMapper;

    public ReserveRepository(ReserveMapper reserveMapper) {
        this.reserveMapper = reserveMapper;
    }

    public void insertReserve(Reserve reserve) {
        reserveMapper.insertReserve(reserve);
    }
}
