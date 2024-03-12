package com.cafe.dao;

import java.util.List;

import com.cafe.entity.NhaCungCap;

public interface INhaCungCapDAO {
	public List<NhaCungCap> selectAll();
	public NhaCungCap selectByid(int id);
	public boolean insert(NhaCungCap ncc);
	public boolean update(NhaCungCap ncc , String meseger);
	public boolean delete(int id);
	

}
