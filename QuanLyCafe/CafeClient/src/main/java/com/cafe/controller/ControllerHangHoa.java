package com.cafe.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.entity.HangHoa;
import com.cafe.entity.HoaDon;

import com.cafe.entity.TempCart;
import com.cafe.util.WebServiceAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/hang-hoa")

public class ControllerHangHoa {
	
	@RequestMapping(value = "/AddtoCart/{id}", method = RequestMethod.GET)
	public String AddtoCart(@PathVariable(value = "id", required = true) int id, Model m) {
		String apiUrl = "http://localhost:8080/CafeSever/rest/hang-hoa/AddtoCart/" + id;
		String json = WebServiceAPI.sendGET(apiUrl);

		Gson gson = new Gson();
		TypeToken<List<HangHoa>> typeToken = new TypeToken<List<HangHoa>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<PhongBan>
		List<HangHoa> lst = gson.fromJson(json, typeToken.getType());
		if (lst != null) {
			m.addAttribute("msg", "Đã thêm vào giỏ hàng thành công");

		} else {
			m.addAttribute("msg", "Thêm mới thất bại!!!");
		}

		m.addAttribute("lst", lst);

		return "Homepage";
	}

	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String Cart(Model m, HttpSession session) {
		String url = "http://localhost:8080/CafeSever/rest/hang-hoa/cart";
		String json = WebServiceAPI.sendGET(url);
		Gson gson = new Gson();
		TypeToken<List<TempCart>> typeToken = new TypeToken<List<TempCart>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<PhongBan>
		List<TempCart> lst = gson.fromJson(json, typeToken.getType());
		double totalPrice = lst.stream().mapToDouble(item -> item.getGia() * item.getSo_luong()).sum();
		m.addAttribute("totalPrice", totalPrice);
		session.setAttribute("totalPrice", totalPrice);
		if (lst != null) {
			m.addAttribute("lst", lst);
			
		}

		return "hang-hoa/cart";
	}

	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public String initPay(Model m) {
		String url = "http://localhost:8080/CafeSever/rest/hoa-don/init-pay";
		String json = WebServiceAPI.sendGET(url);
		Gson gson = new Gson();
		HoaDon hd = gson.fromJson(json, HoaDon.class);
	
		m.addAttribute("hd", hd);
		return "hang-hoa/pay";
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@Valid @ModelAttribute("hd") HoaDon hd, BindingResult result, Model m, HttpSession session) {
		String url = "http://localhost:8080/CafeSever/rest/hoa-don/pay";
		Gson gson = new Gson();
		String jsonObj = gson.toJson(hd);
		String json = WebServiceAPI.sendPOST(url, jsonObj);
		hd = gson.fromJson(json, HoaDon.class);
		
		// Kiểm tra thông báo từ server
		if (hd != null) {
			m.addAttribute("msg", "Thanh toán thành công!!");
			m.addAttribute("hd", hd);
			Double totalPrice = (Double) session.getAttribute("totalPrice");
			m.addAttribute("totalPrice", totalPrice);

			return "hang-hoa/view-pay";
		} else {
			m.addAttribute("msg", "Thanh toán thất bại!!");

			return "hang-hoa/pay";
		}
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable(value = "id", required = true) int id, Model m) {
		String apiUrl = "http://localhost:8080/CafeSever/rest/hang-hoa/delete/" + id;

		String json = WebServiceAPI.sendGET(apiUrl);

		// Chuyển đổi JSON thành đối tượng hàng hóa (sử dụng Gson hoặc thư viện JSON
		// khác)
		Gson gson = new Gson();
		TypeToken<List<TempCart>> typeToken = new TypeToken<List<TempCart>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<PhongBan>
		List<TempCart> lst = gson.fromJson(json, typeToken.getType());

		if (lst != null) {
			m.addAttribute("msg", "Xóa thành công");

		} else {
			m.addAttribute("msg", "Xóa thất bại!!!");
		}
		m.addAttribute("lst", lst);

		return "redirect:/hang-hoa/cart";
	}

}
