package com.cafe.dao;

import java.util.List;

import com.cafe.entity.HangHoa;
import com.cafe.entity.TempCart;


public interface ITempCartDAO {
	public List<TempCart> selectAll();
//	public HangHoa selectByid(int id);
//	public boolean update(HangHoa hh);
	public boolean insert(List<TempCart> tempCart);
	public boolean delete(int id);
	public void deleteAll();
//	public List<HangHoa> search(String search);
	

}
