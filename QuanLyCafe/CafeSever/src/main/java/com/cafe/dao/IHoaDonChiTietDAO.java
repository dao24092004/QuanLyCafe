package com.cafe.dao;

import java.util.List;

import com.cafe.entity.HangHoa;
import com.cafe.entity.HoaDonChiTiet;
import com.cafe.entity.TempCart;


public interface IHoaDonChiTietDAO {

	public void insert(HoaDonChiTiet hdct) ;
	public List<HoaDonChiTiet> selectAll();
	
	

}
