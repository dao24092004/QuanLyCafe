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
@Entity
@Table(name = "tbl_diem_thuong")
public class DiemThuong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	@Transient
	@Column(name = "id_khach_hang")
	private int id_khach_hang ;
	@Column(name = "noi_dung")
	private String noi_dung ;
	@Column(name = "diem")
	private int diem ;
	@Column(name = "ngay_tao")
	private  Date ngay_tao;
	private KhachHang khachhang;
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public DiemThuong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiemThuong(int id, int id_khach_hang, String noi_dung, int diem, Date ngay_tao) {
		super();
		this.id = id;
		this.id_khach_hang = id_khach_hang;
		this.noi_dung = noi_dung;
		this.diem = diem;
		this.ngay_tao = ngay_tao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_khach_hang() {
		return id_khach_hang;
	}
	public void setId_khach_hang(int id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public Date getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	
}
