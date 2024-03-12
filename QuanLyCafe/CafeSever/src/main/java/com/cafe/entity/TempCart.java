package com.cafe.entity;


import java.util.Date;
import java.util.jar.Attributes.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_temp_cart")
@NamedQuery(name = "SELECT_ALL_TMPC",query = "from TempCart")
public class TempCart  {
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Transient
	@Column(name = "id_hang_hoa")
	private int id_hang_hoa;
	@Column(name = "so_luong")
	private Float so_luong;
	@Column(name = "gia")
	private Float gia;
	@ManyToOne
	@JoinColumn(name = "id_hang_hoa",referencedColumnName = "id")
	private HangHoa hanghoa;
	public TempCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TempCart(int id, int id_hang_hoa, Float so_luong, Float gia, HangHoa hanghoa) {
		super();
		this.id = id;
		this.id_hang_hoa = id_hang_hoa;
		this.so_luong = so_luong;
		this.gia = gia;
		this.hanghoa = hanghoa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_hang_hoa() {
		return id_hang_hoa;
	}
	public void setId_hang_hoa(int id_hang_hoa) {
		this.id_hang_hoa = id_hang_hoa;
	}
	public Float getSo_luong() {
		return so_luong;
	}
	public void setSo_luong(Float so_luong) {
		this.so_luong = so_luong;
	}
	public Float getGia() {
		return gia;
	}
	public void setGia(Float gia) {
		this.gia = gia;
	}
	public HangHoa getHanghoa() {
		return hanghoa;
	}
	public void setHanghoa(HangHoa hanghoa) {
		this.hanghoa = hanghoa;
	}
	
	
}
