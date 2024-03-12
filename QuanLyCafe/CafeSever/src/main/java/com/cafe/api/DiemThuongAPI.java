package com.cafe.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cafe.dao.IDiemThuongDAO;
import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplDiemThuongDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.DiemThuong;
import com.cafe.entity.NhanVien;
import com.google.gson.Gson;

@Path("/diem-thuong")
public class DiemThuongAPI {
	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String index() {
		IDiemThuongDAO dtDAO = new ImplDiemThuongDAO();
		List<DiemThuong> lst = dtDAO.selectAll();
		Gson gson = new Gson();
		String json = gson.toJson(lst);
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
