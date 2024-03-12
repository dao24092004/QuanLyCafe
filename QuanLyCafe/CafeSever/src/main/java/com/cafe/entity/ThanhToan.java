package com.cafe.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_thanh_toan")
public class ThanhToan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten")
	private String ten;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	@Column(name = "trang_thai")
	private Short trang_thai;
	@Transient
	@OneToMany(mappedBy = "thanhtoan",fetch = FetchType.EAGER)
	private List<HoaDon> lsthoadontt;
	public ThanhToan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThanhToan(int id, String ten, String ghi_chu, Short trang_thai) {
		super();
		this.id = id;
		this.ten = ten;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
	

}
