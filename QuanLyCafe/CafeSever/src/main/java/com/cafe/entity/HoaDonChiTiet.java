package com.cafe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.NamedQuery;


@Entity
@Table(name = "tbl_hoa_don_chi_tiet")
@NamedQuery(name = "SELECT_ALL_KH", query = "from KhachHang")
@IdClass(HoaDonChiTietId.class)
public class HoaDonChiTiet {
	@Column(name = "so_luong")
	private int so_luong;
	@Column(name = "gia")
	private Float gia;
	@Id
	@Column(name = "id_hoa_don")
	private int id_hoa_don;
	@Id
	@Column(name = "id_hang_hoa")
	private int id_hang_hoa;
	@Transient
	@ManyToOne
	@JoinColumn(name = "id_hoa_don", referencedColumnName = "id")
	HoaDon hoadon;
	@Transient
	@ManyToOne
	@JoinColumn(name = "id_hang_hoa", referencedColumnName = "id")
	HangHoa HoaDonHangHoa;

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public HangHoa getHoaDonHangHoa() {
		return HoaDonHangHoa;
	}

	public void setHoaDonHangHoa(HangHoa hoaDonHangHoa) {
		HoaDonHangHoa = hoaDonHangHoa;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}

	public Float getGia() {
		return gia;
	}

	public void setGia(Float gia) {
		this.gia = gia;
	}

	public int getId_hoa_don() {
		return id_hoa_don;
	}

	public void setId_hoa_don(int id_hoa_don) {
		this.id_hoa_don = id_hoa_don;
	}

	public int getId_hang_hoa() {
		return id_hang_hoa;
	}

	public void setId_hang_hoa(int id_hang_hoa) {
		this.id_hang_hoa = id_hang_hoa;
	}

	public HoaDonChiTiet(int so_luong, Float gia, int id_hoa_don, int id_hang_hoa) {
		super();
		this.so_luong = so_luong;
		this.gia = gia;
		this.id_hoa_don = id_hoa_don;
		this.id_hang_hoa = id_hang_hoa;
	}

	public HoaDonChiTiet() {
		super();
		// TODO Auto-generated constructor stub
	}
}
