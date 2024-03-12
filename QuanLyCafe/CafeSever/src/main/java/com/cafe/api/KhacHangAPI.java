package com.cafe.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cafe.dao.IDiemThuongDAO;
import com.cafe.dao.IKhachHangDAO;
import com.cafe.dao.ImplDiemThuongDAO;
import com.cafe.dao.ImplKhachHangDAO;
import com.cafe.entity.DiemThuong;
import com.cafe.entity.KhachHang;


import com.google.gson.Gson;

@Path("/khach-hang")
public class KhacHangAPI {

	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String index() {
		  IKhachHangDAO khDAO = new ImplKhachHangDAO();
		    List<KhachHang> lstKhachHang = khDAO.selectAll();
		    Gson gson = new Gson();
		    String json = gson.toJson(lstKhachHang);
		    return json;
}
	@Path("/search")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String search(String jsonObj) {
		IKhachHangDAO khDAO = new ImplKhachHangDAO();
		Gson gson = new Gson();
		String khjson = gson.fromJson(jsonObj, String.class);
		KhachHang kh = khDAO.searchCustomer(khjson);
		String json  = gson.toJson(kh);
		System.out.println("có khách hàng "+ kh);
		return json;
	}
	@Path("/init-gift/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String initGift(@PathParam("id") int id) {
		IDiemThuongDAO dtDAO = new ImplDiemThuongDAO();
		DiemThuong dt = dtDAO.selectByid(id);
		System.out.println("Nhân viên: " + dt);
		Gson gson = new Gson();
		String json = gson.toJson(dt);
		return json;
	}
	
}
