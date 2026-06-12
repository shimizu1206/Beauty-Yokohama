package com.example.music_management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.music_management.entity.Shop;
import com.example.music_management.entity.Staff;

@Mapper
public interface StaffMapper {
    @Select("SELECT * FROM staff")
    List<Staff> selectAllStaffs();

    @Select("SELECT * FROM staff WHERE staff_id = #{staffId}")
    Staff selectStaffById(long itemId);

    @Select("SELECT * FROM staff WHERE shop_id = #{shopId}")
    List<Staff> selectStaffsByStaffId(long staffId);
}
