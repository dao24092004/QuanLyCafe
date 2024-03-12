package com.cafe.dao;

import com.cafe.entity.HoaDon;


public interface IHoaDonDAO {
	boolean insert(HoaDon hd);
	public int getByNameAndPhone(String name,String phone);
	public HoaDon selectByid(int id);
	
}
