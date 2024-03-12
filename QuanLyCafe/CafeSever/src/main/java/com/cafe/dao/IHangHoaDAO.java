package com.cafe.dao;

import java.util.List;

import com.cafe.entity.HangHoa;
import com.cafe.entity.TempCart;


public interface IHangHoaDAO {
	public List<HangHoa> selectAll();
	public HangHoa selectByid(int id);
	public boolean update(HangHoa hh);
	public boolean insert(HangHoa hh);
	public boolean delete(int id);
	public List<HangHoa> search(String search);
	
	

}
