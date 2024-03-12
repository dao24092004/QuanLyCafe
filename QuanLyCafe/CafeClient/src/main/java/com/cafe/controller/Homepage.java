package com.cafe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe.entity.HangHoa;
import com.cafe.util.WebServiceAPI;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/")
public class Homepage {
	@RequestMapping(value = { "", "/", "/list" })
	public String index(Model m) {
		// Call tới API và lấy dữ liệu phòng ban về
		String url = "http://localhost:8080/CafeSever/rest/hang-hoa";
		String json = WebServiceAPI.sendGET(url);
		Gson gson = new Gson();

		TypeToken<List<HangHoa>> typeToken = new TypeToken<List<HangHoa>>() {
		}; // Định nghĩa 1 TypeToken cho đối tượng List<PhongBan>
		List<HangHoa> lst = gson.fromJson(json, typeToken.getType());
		// Calculate total price

		m.addAttribute("lst", lst);
		return "Homepage";
	}

	
}
