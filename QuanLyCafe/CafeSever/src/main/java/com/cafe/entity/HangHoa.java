package com.cafe.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_hang_hoa")
@NamedQuery(name = "SELECT_ALL_HH",query = "from HangHoa")
public class HangHoa {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "bar_code")
	
	private String bar_code;
	@Column(name = "ten_hang_hoa")
	
	private String ten_hang_hoa;
	@Transient
	@Column(name = "id_chung_loai")
	private int id_chung_loai;
	@Transient
	@Column(name = "id_don_vi_tinh")
	private int id_don_vi_tinh;
	@Transient
	@Column(name = "id_nhacc")
	private int id_nhacc;
	@Column(name = "so_luong")
	private Float so_luong;
	@Column(name = "gia_nhap")
	private Float gia_nhap;
	@Column(name = "gia_xuat")
	private Float gia_xuat;
	@Column(name = "ngay_tao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_tao;
	@Column(name = "ngay_cap_nhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_cap_nhat;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	
	@ManyToOne
	@JoinColumn(name = "id_chung_loai", referencedColumnName = "id")
	private ChungLoai chungloai;
	
	@ManyToOne
	@JoinColumn(name = "id_don_vi_tinh", referencedColumnName = "id")
	private DonViTinh donvi;
	@ManyToOne
	@JoinColumn(name = "id_nhacc", referencedColumnName = "id")
	private NhaCungCap nhacung;
	@Transient
	@OneToMany(mappedBy = "hanghoa",fetch = FetchType.EAGER)
	private List<TempCart> lstTemp;
	@Transient
	@OneToMany(mappedBy = "HoaDonHangHoa",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<HoaDonChiTiet> lstHoaDonChiTiet;
	public List<HoaDonChiTiet> getLstHoaDonChiTiet() {
		return lstHoaDonChiTiet;
	}

	public void setLstHoaDonChiTiet(List<HoaDonChiTiet> lstHoaDonChiTiet) {
		this.lstHoaDonChiTiet = lstHoaDonChiTiet;
	}

	public List<TempCart> getLstTemp() {
		return lstTemp;
	}

	public void setLstTemp(List<TempCart> lstTemp) {
		this.lstTemp = lstTemp;
	}

	public NhaCungCap getNhacung() {
		return nhacung;
	}

	public void setNhacung(NhaCungCap nhacung) {
		this.nhacung = nhacung;
	}

	public DonViTinh getDonvi() {
		return donvi;
	}

	public void setDonvi(DonViTinh donvi) {
		this.donvi = donvi;
	}
	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}
public HangHoa(int id, String bar_code, String ten_hang_hoa, int id_chung_loai, int id_don_vi_tinh, int id_nhacc,
		Float so_luong, Float gia_nhap, Float gia_xuat, Date ngay_tao, Date ngay_cap_nhat, String ghi_chu) {
	super();
	this.id = id;
	this.bar_code = bar_code;
	this.ten_hang_hoa = ten_hang_hoa;
	this.id_chung_loai = id_chung_loai;
	this.id_don_vi_tinh = id_don_vi_tinh;
	this.id_nhacc = id_nhacc;
	this.so_luong = so_luong;
	this.gia_nhap = gia_nhap;
	this.gia_xuat = gia_xuat;
	this.ngay_tao = ngay_tao;
	this.ngay_cap_nhat = ngay_cap_nhat;
	this.ghi_chu = ghi_chu;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBar_code() {
	return bar_code;
}
public void setBar_code(String bar_code) {
	this.bar_code = bar_code;
}
public String getTen_hang_hoa() {
	return ten_hang_hoa;
}
public void setTen_hang_hoa(String ten_hang_hoa) {
	this.ten_hang_hoa = ten_hang_hoa;
}
public int getId_chung_loai() {
	return id_chung_loai;
}
public void setId_chung_loai(int id_chung_loai) {
	this.id_chung_loai = id_chung_loai;
}
public int getId_don_vi_tinh() {
	return id_don_vi_tinh;
}
public void setId_don_vi_tinh(int id_don_vi_tinh) {
	this.id_don_vi_tinh = id_don_vi_tinh;
}
public int getId_nhacc() {
	return id_nhacc;
}
public void setId_nhacc(int id_nhacc) {
	this.id_nhacc = id_nhacc;
}
public Float getSo_luong() {
	return so_luong;
}
public void setSo_luong(Float so_luong) {
	this.so_luong = so_luong;
}
public Float getGia_nhap() {
	return gia_nhap;
}
public void setGia_nhap(Float gia_nhap) {
	this.gia_nhap = gia_nhap;
}
public Float getGia_xuat() {
	return gia_xuat;
}
public void setGia_xuat(Float gia_xuat) {
	this.gia_xuat = gia_xuat;
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
public String getGhi_chu() {
	return ghi_chu;
}
public void setGhi_chu(String ghi_chu) {
	this.ghi_chu = ghi_chu;
}



	public ChungLoai getChungloai() {
		return chungloai;
	}

	public void setChungloai(ChungLoai chungloai) {
		this.chungloai = chungloai;
	}
}
