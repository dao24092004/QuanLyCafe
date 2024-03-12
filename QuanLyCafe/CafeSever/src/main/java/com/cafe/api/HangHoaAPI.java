package com.cafe.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.cafe.dao.IHangHoaDAO;
import com.cafe.dao.ITempCartDAO;
import com.cafe.dao.ImplHangHoaDAO;
import com.cafe.dao.ImplTempCartDAO;
import com.cafe.entity.HangHoa;

import com.cafe.entity.TempCart;

import com.google.gson.Gson;


@Path("/hang-hoa")
public class HangHoaAPI {


	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String index() {
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		List<HangHoa> lst = hhDAO.selectAll();
		System.out.println("lst hang hoa" + lst);
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		return json;
	}

	// Hàm lấy thông tin sản phẩm từ database

	// Hàm thêm vào giỏ hàng
	private void addToTempCart(int id, List<TempCart> tempCart) {
		// lưu thông tin vào session
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		List<HangHoa> lst = hhDAO.selectAll();
		System.out.println("danh sách hàng hóa" + lst);
		HangHoa hangHoa = hhDAO.selectByid(id); // Gọi trực tiếp từ DAO

		if (hangHoa != null) {
			TempCart tempItem = new TempCart();
			tempItem.setHanghoa(hangHoa);
			tempItem.setId_hang_hoa(hangHoa.getId());
			tempItem.setSo_luong(1.0f); // Số lượng mặc định là 1
			tempItem.setGia(hangHoa.getGia_xuat());
			tempCart.add(tempItem);
		} else {
			// Xử lý trường hợp không tìm thấy sản phẩm
			System.out.println("Không tìm thấy sản phẩm với ID: " + id);
		} // Gọi trực tiếp từ controller

	}

	@Path("/AddtoCart/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String addToCart(@PathParam("id") int id) {
		List<TempCart> tempCart = new ArrayList<>();

		addToTempCart(id, tempCart);
		ITempCartDAO tempDAO = new ImplTempCartDAO();
		boolean isOK = tempDAO.insert(tempCart);
		System.out.println("Thông tin hàng hóa" + tempCart);
		IHangHoaDAO hhDAO = new ImplHangHoaDAO();
		List<HangHoa> lst = null;
		if (isOK) {
			lst = hhDAO.selectAll();
		} else {
			System.out.println("Thêm thất bại!!");
		}
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		return json;
	}

	@Path("/cart")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String cart() {
		ITempCartDAO tempDAO = new ImplTempCartDAO();
		List<TempCart> lst = tempDAO.selectAll();
		Gson gson = new Gson();
		String json = gson.toJson(lst);
		return json;
	}

	@Path("delete/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteCart(@PathParam("id") int id) {
		ITempCartDAO tempDAO = new ImplTempCartDAO();
		boolean isOk = tempDAO.delete(id);
		List<TempCart> lst = null;
		if (isOk) {
			lst = tempDAO.selectAll();
		} else {
			System.out.println("xóa thất bại!!!");
		}

		Gson gson = new Gson();

		String json = gson.toJson(lst);
		return json;
	}
	
	

}
