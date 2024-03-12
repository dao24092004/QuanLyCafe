package com.cafe.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "tbl_thong_ke")
public class ThongKe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	@Column(name = "ten_hang_hoa")
    private String ten_hang_hoa ;
	@Column(name = "so_luong")
    private Float so_luong ;
	@Column(name = "doanh_thu")
    private Float doanh_thu ;
	@Column(name = "ngay_thong_ke")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngay_thong_ke;
	public ThongKe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongKe(int id, String ten_hang_hoa, Float so_luong, Float doanh_thu, Date ngay_thong_ke) {
		super();
		this.id = id;
		this.ten_hang_hoa = ten_hang_hoa;
		this.so_luong = so_luong;
		this.doanh_thu = doanh_thu;
		this.ngay_thong_ke = ngay_thong_ke;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_hang_hoa() {
		return ten_hang_hoa;
	}
	public void setTen_hang_hoa(String ten_hang_hoa) {
		this.ten_hang_hoa = ten_hang_hoa;
	}
	public Float getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(Float so_luong) {
		this.so_luong = so_luong;
	}
	public Float getDoanh_thu() {
		return doanh_thu;
	}
	public void setDoanh_thu(Float doanh_thu) {
		this.doanh_thu = doanh_thu;
	}
	public Date getNgay_thong_ke() {
		return ngay_thong_ke;
	}
	public void setNgay_thong_ke(Date ngay_thong_ke) {
		this.ngay_thong_ke = ngay_thong_ke;
	}
    

}
