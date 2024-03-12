package com.cafe.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_phan_quyen")
public class PhanQuyen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private int id ; 
	@Column(name = "ten_quyen")
	private String ten_quyen ;
	@Column(name = "vi_tri")
	private String vi_tri ;
	@Column(name = "ngay_tao")
	private Date ngay_tao ;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	@OneToMany(mappedBy = "phanquyen",fetch = FetchType.EAGER)
	private List<NhanVien> lstpq;
	
	public List<NhanVien> getLstpq() {
		return lstpq;
	}
	public void setLstpq(List<NhanVien> lstpq) {
		this.lstpq = lstpq;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen_quyen() {
		return ten_quyen;
	}
	public void setTen_quyen(String ten_quyen) {
		this.ten_quyen = ten_quyen;
	}
	public String getVi_tri() {
		return vi_tri;
	}
	public void setVi_tri(String vi_tri) {
		this.vi_tri = vi_tri;
	}
	public Date getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public PhanQuyen(int id, String ten_quyen, String vi_tri, Date ngay_tao, String ghi_chu) {
		super();
		this.id = id;
		this.ten_quyen = ten_quyen;
		this.vi_tri = vi_tri;
		this.ngay_tao = ngay_tao;
		this.ghi_chu = ghi_chu;
	}
	public PhanQuyen() {
		super();
		// TODO Auto-generated constructor stub
	}
}
