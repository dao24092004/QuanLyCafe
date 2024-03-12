package com.cafe.dao;

import java.util.List;

import com.cafe.entity.KhachHang;

public interface IKhachHangDAO {
	public List<KhachHang> selectAll();
	
	public KhachHang searchCustomer(String phoneNumberOrEmail);
	

//	public KhachHang selectByid(int id);
//
//	public boolean insert(KhachHang kh);

}
