package com.cafe.dao;

import java.util.List;

import com.cafe.entity.DonViTinh;

public interface IDonViTinhDAO {
	public DonViTinh selectByid(int id);
	public List<DonViTinh> selectAll();
}
