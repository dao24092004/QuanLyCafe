package com.cafe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.cafe.entity.DiemThuong;
import com.cafe.entity.KhachHang;
import com.cafe.entity.NhanVien;
import com.cafe.util.WebServiceAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/khach-hang")
public class ControllerKhachhang {
	@RequestMapping(value = { "", "/", "/list" })
	public String index(Model m) {
		// Call tới API và lấy dữ liệu phòng ban về
		String url = "http://localhost:8080/CafeSever/rest/khach-hang";
		String json = WebServiceAPI.sendGET(url);
		Gson gson = new Gson();

		TypeToken<List<KhachHang>> typeToken = new TypeToken<List<KhachHang>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<KhachHang>
		List<KhachHang> lst = gson.fromJson(json, typeToken.getType());

		m.addAttribute("lst", lst);
		return "khach-hang/index";
	}

	@RequestMapping(value = "/gift/{id}", method = RequestMethod.GET)
	public String initGift(@PathVariable(value = "id", required = true) int id, Model m) {
		String apiUrl = "http://localhost:8080/CafeSever/rest/diem-thuong/init-gift/" + id;

		// Gửi yêu cầu GET để lấy thông tin nhân viên
		String json = WebServiceAPI.sendGET(apiUrl);
		System.out.println("Init gift URL: " + apiUrl);
		System.out.println("id nhân vien là " + id);
		// Chuyển đổi JSON thành đối tượng NhânVien (sử dụng Gson hoặc thư viện JSON
		// khác)
		Gson gson = new Gson();
		DiemThuong dt = gson.fromJson(json, DiemThuong.class);
		System.out.println("khách hàng" + dt);
		if (dt != null) {
			// Dữ liệu trả về không rỗng, thì thêm vào Model để sử dụng trong trang JSP
			m.addAttribute("dt", dt);
			m.addAttribute("msg", "Chào mừng quý khách");
		} else {
			System.out.println("Không có dữ liệu trả về cho khách hàng có ID = " + id);
		}
		return "khach-hang/diem-thuong";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(name = "TxtSearch") String search, Model m) {

		String url = "http://localhost:8080/CafeSever/rest/khach-hang/search";
		Gson gson = new Gson();
		String jsonObj = gson.toJson(search);
		String json = WebServiceAPI.sendPOST(url, jsonObj);
		KhachHang khachhang = gson.fromJson(json, KhachHang.class);
		List<KhachHang> lst = new ArrayList<KhachHang>();
		lst.add(khachhang);
		System.out.println(lst);

		m.addAttribute("lst", lst);
		return "khach-hang/index";
	}

}
