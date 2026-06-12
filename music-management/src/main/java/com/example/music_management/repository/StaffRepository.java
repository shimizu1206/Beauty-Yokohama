package com.example.music_management.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.music_management.entity.Staff;
import com.example.music_management.mapper.StaffMapper;

@Repository
public class StaffRepository {
      private final StaffMapper staffMapper;

    public StaffRepository(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    public Staff getStaffById(long albumId) {
        return staffMapper.selectStaffById(albumId);
    }

    public List<Staff> getAllStaff() {
        return staffMapper.selectAllStaffs();
    }

    public List<Staff> getStaffsBystaffId(long staffId){
        return staffMapper.selectStaffsByStaffId(staffId);
    }
}
