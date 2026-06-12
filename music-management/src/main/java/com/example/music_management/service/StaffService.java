package com.example.music_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.music_management.entity.Staff;
import com.example.music_management.repository.StaffRepository;


    @Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository){ 
        this.staffRepository = staffRepository;
    }
        public List<Staff> getAllStaff(){
        return staffRepository.getAllStaff();
    }
    public Staff getStaffById(long albumId) {
        return staffRepository.getStaffById(albumId);
    }

    public List<Staff> getStaffsBystaffId(long staffId){
        return staffRepository.getStaffsBystaffId(staffId);
    }
}