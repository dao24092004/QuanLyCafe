package com.cafe.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_hoa_don")
@NamedQuery(name = "SELECT_ALL_HD", query = "from HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "ngay_tao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_tao;

	@Column(name = "ngay_giao_hang")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_giao_hang;
	@Transient
	@Column(name = "id_thanh_toan")
	private int id_thanh_toan;
	
	@Column(name = "id_khach_hang")
	private int id_khach_hang;
	
	@Column(name = "id_nhan_vien")
	private int id_nhan_vien;

	@Column(name = "trang_thai")
	private Short trang_thai;

	@Column(name = "dia_chi_nhan")
	private String dia_chi_nhan;

	@Column(name = "sdt_nhan")
	private String sdt_nhan;

	@Column(name = "ghi_chu")
	private String ghi_chu;

	@Transient
	@OneToMany(mappedBy = "hoadon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<HoaDonChiTiet> lstHoaDonChiTiet;
	@Transient
	@ManyToOne
	@JoinColumn(name = "id_khach_hang", referencedColumnName = "id" )
	private KhachHang hdkhachhang;
	@Transient
	@ManyToOne
	@JoinColumn(name = "id_nhan_vien", referencedColumnName = "id" )
	private NhanVien nhanvien;

	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(int id, Date ngay_tao, Date ngay_giao_hang, int id_thanh_toan, int id_khach_hang, int id_nhan_vien,
			Short trang_thai, String dia_chi_nhan, String sdt_nhan, String ghi_chu) {
		super();
		this.id = id;
		this.ngay_tao = ngay_tao;
		this.ngay_giao_hang = ngay_giao_hang;
		this.id_thanh_toan = id_thanh_toan;
		this.id_khach_hang = id_khach_hang;
		this.id_nhan_vien = id_nhan_vien;
		this.trang_thai = trang_thai;
		this.dia_chi_nhan = dia_chi_nhan;
		this.sdt_nhan = sdt_nhan;
		this.ghi_chu = ghi_chu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getNgay_tao() {
		return ngay_tao;
	}
	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}
	public Date getNgay_giao_hang() {
		return ngay_giao_hang;
	}
	public void setNgay_giao_hang(Date ngay_giao_hang) {
		this.ngay_giao_hang = ngay_giao_hang;
	}
	public int getId_thanh_toan() {
		return id_thanh_toan;
	}
	public void setId_thanh_toan(int id_thanh_toan) {
		this.id_thanh_toan = id_thanh_toan;
	}
	public int getId_khach_hang() {
		return id_khach_hang;
	}
	public void setId_khach_hang(int id_khach_hang) {
		this.id_khach_hang = id_khach_hang;
	}
	public int getId_nhan_vien() {
		return id_nhan_vien;
	}
	public void setId_nhan_vien(int id_nhan_vien) {
		this.id_nhan_vien = id_nhan_vien;
	}
	public Short getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(Short trang_thai) {
		this.trang_thai = trang_thai;
	}
	public String getDia_chi_nhan() {
		return dia_chi_nhan;
	}
	public void setDia_chi_nhan(String dia_chi_nhan) {
		this.dia_chi_nhan = dia_chi_nhan;
	}
	public String getSdt_nhan() {
		return sdt_nhan;
	}
	public void setSdt_nhan(String sdt_nhan) {
		this.sdt_nhan = sdt_nhan;
	}
	public String getGhi_chu() {
		return ghi_chu;
	}
	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}
	public List<HoaDonChiTiet> getLstHoaDonChiTiet() {
		return lstHoaDonChiTiet;
	}
	public void setLstHoaDonChiTiet(List<HoaDonChiTiet> lstHoaDonChiTiet) {
		this.lstHoaDonChiTiet = lstHoaDonChiTiet;
	}
	public KhachHang getHdkhachhang() {
		return hdkhachhang;
	}
	public void setHdkhachhang(KhachHang hdkhachhang) {
		this.hdkhachhang = hdkhachhang;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	
}
