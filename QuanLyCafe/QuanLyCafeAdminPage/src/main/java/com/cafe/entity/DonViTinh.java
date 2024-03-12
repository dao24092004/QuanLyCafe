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

@Entity
@Table(name = "tbl_don_vi_tinh")
public class DonViTinh {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "ten_don_vi")
	private String ten_don_vi;
	@OneToMany(mappedBy = "donvi", fetch = FetchType.EAGER)
	private List<HangHoa> lstHangHoa;

	public List<HangHoa> getLstHangHoa() {
		return lstHangHoa;
	}

	public void setLstHangHoa(List<HangHoa> lstHangHoa) {
		this.lstHangHoa = lstHangHoa;
	}

	public DonViTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonViTinh(Integer id, String ten_don_vi) {
		super();
		this.id = id;
		this.ten_don_vi = ten_don_vi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen_don_vi() {
		return ten_don_vi;
	}

	public void setTen_don_vi(String ten_don_vi) {
		this.ten_don_vi = ten_don_vi;
	}

}
