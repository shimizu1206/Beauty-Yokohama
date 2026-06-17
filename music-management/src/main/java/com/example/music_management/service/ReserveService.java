package com.example.music_management.service;

import com.example.music_management.repository.ReserveRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.music_management.entity.Reserve;
import com.example.music_management.form.ReserveForm;
@Service
public class ReserveService {
    private final ReserveRepository reserveRepository;
    public ReserveService(ReserveRepository reserveRepository) {
        this.reserveRepository = reserveRepository;
    }

    public void createReserve(ReserveForm reserveForm) { //アルバムを作る
        Reserve reserve = new Reserve();
        reserve.setShopName(reserveForm.getShopName());
        reserve.setUserName(reserveForm.getUserName());
        reserve.setStaffName(reserveForm.getStaffName());
        reserve.setMenu(reserveForm.getMenu());
        reserve.setPrice(reserveForm.getPrice());
        reserve.setDateAndTime(reserveForm.getDateAndTime());
        reserve.setItem(reserveForm.getItem());
        reserve.setShopId(reserveForm.getShopId());
        reserveRepository.insertReserve(reserve);
    }

    public List<Reserve> getReserveById() {//
        return reserveRepository.getReserveById();
    }

    public void deleteReserve(long reserveId) {
        reserveRepository.deleteReserve(reserveId);
    }
}
