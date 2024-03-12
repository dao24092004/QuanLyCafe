package com.cafe.dao;

import java.util.List;

import com.cafe.entity.ChungLoai;

public interface IChungLoaiDAO {
	public ChungLoai selectByid(int i);
	public List<ChungLoai> selectAll();
}
