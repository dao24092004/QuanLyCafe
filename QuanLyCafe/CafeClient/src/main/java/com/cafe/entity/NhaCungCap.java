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
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_nha_cung_cap")
public class NhaCungCap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "ten_nhacc")
	@NotEmpty(message = "Không để trống!!!")
	private String ten_nhacc;
	@Column(name = "dia_chi")
	@NotEmpty(message = "Không để trống!!!")
	private String dia_chi;
	@Column(name = "sdt1")
	@NotEmpty(message = "Không để trống!!!")
	private String sdt1;
	@Column(name = "sdt2")
	private String sdt2;
	@Column(name = "fax")
	private String fax;
	@Column(name = "email")
	@NotEmpty(message = "Buộc phải nhập!!!")
	@Email(message = "Phải nhập đúng kiểu Email")
	private String email;
	@Column(name = "website")
	@NotEmpty(message = "Không để trống!!!")
	private String website;
	@Column(name = "gay_tao")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date gay_tao;
	@Column(name = "ngay_cap_nhat")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay_cap_nhat;
	@Column(name = "tax_code")
	private String tax_code;
	@Column(name = "ghi_chu")
	private String ghi_chu;
	@Column(name = "trang_thai")
	private Short trang_thai;
	

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaCungCap(int id, String ten_nhacc, String dia_chi, String sdt1, String sdt2, String fax, String email,
			String website, Date gay_tao, Date ngay_cap_nhat, String tax_code, String ghi_chu, Short trang_thai) {
		super();
		this.id = id;
		this.ten_nhacc = ten_nhacc;
		this.dia_chi = dia_chi;
		this.sdt1 = sdt1;
		this.sdt2 = sdt2;
		this.fax = fax;
		this.email = email;
		this.website = website;
		this.gay_tao = gay_tao;
		this.ngay_cap_nhat = ngay_cap_nhat;
		this.tax_code = tax_code;
		this.ghi_chu = ghi_chu;
		this.trang_thai = trang_thai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen_nhacc() {
		return ten_nhacc;
	}

	public void setTen_nhacc(String ten_nhacc) {
		this.ten_nhacc = ten_nhacc;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getSdt1() {
		return sdt1;
	}

	public void setSdt1(String sdt1) {
		this.sdt1 = sdt1;
	}

	public String getSdt2() {
		return sdt2;
	}

	public void setSdt2(String sdt2) {
		this.sdt2 = sdt2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getGay_tao() {
		return gay_tao;
	}

	public void setGay_tao(Date gay_tao) {
		this.gay_tao = gay_tao;
	}

	public Date getNgay_cap_nhat() {
		return ngay_cap_nhat;
	}

	public void setNgay_cap_nhat(Date ngay_cap_nhat) {
		this.ngay_cap_nhat = ngay_cap_nhat;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
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
