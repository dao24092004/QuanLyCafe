package com.cafe.dao;

import java.util.List;


import com.cafe.entity.PhanQuyen;

public interface IPhanQuyenDAO {
	public PhanQuyen selectByid(int id);
	public List<PhanQuyen> selectAll();
}
