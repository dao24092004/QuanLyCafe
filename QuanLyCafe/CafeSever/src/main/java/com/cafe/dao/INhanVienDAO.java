package com.cafe.dao;

import java.util.List;


import com.cafe.entity.NhanVien;

public interface INhanVienDAO {
	public List<NhanVien> selectAll();
//	public List<NhanVien> search(String search);
	public NhanVien selectByid(int id);
//	public boolean insert(NhanVien nv);
	public boolean update(NhanVien nv);
	public NhanVien selectByName(String username);
	public boolean isUsernameAndPasswordValid(String username, String passwords);
//	public boolean delete(int id);
}
