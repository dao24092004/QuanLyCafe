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
@Table(name = "tbl_chung_loai")
public class ChungLoai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "ten")
	private String ten;
	@Transient
	@OneToMany(mappedBy = "chungloai" , fetch = FetchType.EAGER)
	private List<HangHoa> lstHangHoa;
	public List<HangHoa> getLstHangHoa() {
		return lstHangHoa;
	}

	public ChungLoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChungLoai(Integer id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}
