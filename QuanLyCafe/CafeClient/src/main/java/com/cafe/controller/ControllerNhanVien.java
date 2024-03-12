package com.cafe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cafe.entity.MessageBox;
import com.cafe.entity.NhanVien;
import com.cafe.util.WebServiceAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/nhan-vien")
public class ControllerNhanVien {
	@RequestMapping(value = { "", "/", "/list" })
	public String index(Model m) {
		// Call tới API và lấy dữ liệu phòng ban về
		String url = "http://localhost:8080/CafeSever/rest/nhan-vien";
		String json = WebServiceAPI.sendGET(url);
		Gson gson = new Gson();

		TypeToken<List<NhanVien>> typeToken = new TypeToken<List<NhanVien>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<PhongBan>
		List<NhanVien> lst = gson.fromJson(json, typeToken.getType());

		m.addAttribute("lst", lst);
		return "nhan-vien/index";
	}

	

	@RequestMapping(value = "/init-update/{id}", method = RequestMethod.GET)
	public String initUpdate(@PathVariable(value = "id", required = true) int id, Model m) {
	    String apiUrl = "http://localhost:8080/CafeSever/rest/nhan-vien/init-update/" + id;

	 // Gửi yêu cầu GET để lấy thông tin nhân viên
	    String json = WebServiceAPI.sendGET(apiUrl);
	    System.out.println("Init Update URL: " + apiUrl);

	    // Chuyển đổi JSON thành đối tượng NhânVien (sử dụng Gson hoặc thư viện JSON khác)
	    Gson gson = new Gson();
	    NhanVien nv = gson.fromJson(json, NhanVien.class);

	    if (nv != null) {
	        // Dữ liệu trả về không rỗng, thì thêm vào Model để sử dụng trong trang JSP
	        m.addAttribute("nv", nv);
	    } else {
	        System.out.println("Không có dữ liệu trả về cho nhân viên có ID = " + id);
	    }

	    return "nhan-vien/update";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("nv") NhanVien nv,BindingResult result , Model m ) {
		 String apiUrl = "http://localhost:8080/CafeSever/rest/nhan-vien/update";

	        // Gửi yêu cầu POST để cập nhật thông tin nhân viên
	        Gson gson = new Gson();
	        String jsObj = gson.toJson(nv);
	        String json = WebServiceAPI.sendPOST(apiUrl, jsObj);
	        System.out.println("Update URL: " + apiUrl);

	        MessageBox msg = gson.fromJson(json, MessageBox.class);
	        String msgString = msg.getMsg();
	        m.addAttribute("msg", msgString);
	        System.out.println("thông tin hiển thị"+msgString);
	        return "nhan-vien/update";
	}



}
