package com.cafe.dao;

import java.util.List;

import com.cafe.entity.DiemThuong;
import com.cafe.entity.NhanVien;


public interface IDiemThuongDAO {
	public List<DiemThuong> selectAll();
	public DiemThuong selectByid(int id);
	
	

}
