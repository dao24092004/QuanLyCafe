package com.cafe.dao;

import java.util.List;

import com.cafe.entity.HangHoa;


public interface IHangHoaDAO {
	public List<HangHoa> selectAll();
	public HangHoa selectByid(int id);
	public boolean update(HangHoa hh);
	public boolean insert(HangHoa hh);
	public boolean delete(int id);
	public List<HangHoa> search(String search);
	public List<Object[]> thongKeTheoNgayThang(int ngay, int thang, int nam);
	public HangHoa selectByName(String ten_hang_hoa);
	

}
