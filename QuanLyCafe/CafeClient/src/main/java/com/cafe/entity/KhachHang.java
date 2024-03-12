package com.cafe.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "tbl_khach_hang")
@NamedQuery(name = "SELECT_ALL_KH", query = "from KhachHang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ho")

	private String ho;
	@Column(name = "ten")

	private String ten;
	@Column(name = "gioi_tinh")
	private Short gioi_tinh;
	@Column(name = "ngay_sinh")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_sinh;
	@Column(name = "dien_thoai")

	private String dien_thoai;
	@Column(name = "dia_chi")

	private String dia_chi;
	@Column(name = "email")

	private String email;
	@Column(name = "ngay_tao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_tao;
	@Column(name = "ngay_cap_nhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_cap_nhat;
	@Column(name = "trang_thai")
	private Short trang_thai;
	
	

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(int id, @NotEmpty(message = "Họ  phải nhập!!!") String ho,
			@NotEmpty(message = "Tên phải nhập!!!") String ten, Short gioi_tinh, Date ngay_sinh,
			@NotEmpty(message = "Buộc phải nhập!!!") String dien_thoai,
			@NotEmpty(message = "Buộc phải nhập!!!") String dia_chi,
			@Email(message = "Phải nhập đúng kiểu Email") String email, Date ngay_tao, Date ngay_cap_nhat,
			Short trang_thai) {
		super();
		this.id = id;
		this.ho = ho;
		this.ten = ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.dien_thoai = dien_thoai;
		this.dia_chi = dia_chi;
		this.email = email;
		
		this.trang_thai = trang_thai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Short getGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(Short gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public Date getNgay_sinh() {
		return ngay_sinh;
	}
	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}
	public String getDien_thoai() {
		return dien_thoai;
	}
	public void setDien_thoai(String dien_thoai) {
		this.dien_thoai = dien_thoai;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	public Date getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}
	public void setNgay_cap_nhat(Date ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}
	public KhachHang(Date ngay_tao, Date ngay_cap_nhat) {
		super();
		this.ngay_tao = ngay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
} 
	