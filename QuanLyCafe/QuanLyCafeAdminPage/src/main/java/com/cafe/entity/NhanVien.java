package com.cafe.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_nhan_vien")
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ho_va_ten")
	@NotEmpty(message = "Họ và tên phải nhập!!!")
	private String ho_va_ten;
	@Column(name = "gioi_tinh")
	private Short gioi_tinh;
	@Column(name = "ngay_sinh")
	@NotNull(message = "Ngày sinh bắt buộc phải nhập!!!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_sinh;
	@Column(name = "ngay_vao_lam")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_vao_lam;
	@Column(name = "di_dong")
	@NotEmpty(message = "Buộc phải nhập!!!")
	private String di_dong;
	@Column(name = "dt_gia_dinh")
	private String dt_gia_dinh;
	@Column(name = "email")
	@NotEmpty(message = "Buộc phải nhập!!!")
	@Email(message = "Email phải nhập đúng!!! ")
	private String email;
	@Column(name = "dia_chi")
	private String dia_chi;
	@Transient
	@Column(name = "id_phan_quyen")	
	private int id_phan_quyen;
	@Column(name = "luong_co_ban")
	private Float luong_co_ban;
	@Column(name = "username")
	@NotEmpty(message = "Bạn phải nhập tên đăng nhập!!!")
	private String username;
	@Column(name = "passwords")
	@NotEmpty(message = "Bạn phải nhập mật khẩu đăng nhập!!!")
	private String passwords;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	@Column(name = "trang_thai")
	private Short trang_thai;
	@ManyToOne
	@JoinColumn(name = "id_phan_quyen",referencedColumnName = "id" )
	private PhanQuyen phanquyen;
	public PhanQuyen getPhanquyen() {
		return phanquyen;
	}

	public void setPhanquyen(PhanQuyen phanquyen) {
		this.phanquyen = phanquyen;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int id, String ho_va_ten, Short gioi_tinh, Date ngay_sinh, Date ngay_vao_lam, String di_dong,
			String dt_gia_dinh, String email, String dia_chi, int id_phan_quyen, Float luong_co_ban, String username,
			String passwords, String ghi_chu, Short trang_thai) {
		super();
		this.id = id;
		this.ho_va_ten = ho_va_ten;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.ngay_vao_lam = ngay_vao_lam;
		this.di_dong = di_dong;
		this.dt_gia_dinh = dt_gia_dinh;
		this.email = email;
		this.dia_chi = dia_chi;
		this.id_phan_quyen = id_phan_quyen;
		this.luong_co_ban = luong_co_ban;
		this.username = username;
		this.passwords = passwords;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHo_va_ten() {
		return ho_va_ten;
	}

	public void setHo_va_ten(String ho_va_ten) {
		this.ho_va_ten = ho_va_ten;
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

	public Date getNgay_vao_lam() {
		return ngay_vao_lam;
	}

	public void setNgay_vao_lam(Date ngay_vao_lam) {
		this.ngay_vao_lam = ngay_vao_lam;
	}

	public String getDi_dong() {
		return di_dong;
	}

	public void setDi_dong(String di_dong) {
		this.di_dong = di_dong;
	}

	public String getDt_gia_dinh() {
		return dt_gia_dinh;
	}

	public void setDt_gia_dinh(String dt_gia_dinh) {
		this.dt_gia_dinh = dt_gia_dinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public int getId_phan_quyen() {
		return id_phan_quyen;
	}

	public void setId_phan_quyen(int id_phan_quyen) {
		this.id_phan_quyen = id_phan_quyen;
	}

	public Float getLuong_co_ban() {
		return luong_co_ban;
	}

	public void setLuong_co_ban(Float luong_co_ban) {
		this.luong_co_ban = luong_co_ban;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
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
