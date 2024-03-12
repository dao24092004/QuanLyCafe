package com.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.NhanVien;

@Controller
@RequestMapping("/admin")
public class ControllerLogin {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username") String username,
			@RequestParam(name = "passwords") String passwords, Model m, HttpSession session) {
		NhanVien nv = new NhanVien();
		m.addAttribute("nv", nv);
		INhanVienDAO nvdao = new ImplNhanVienDAO();
		boolean isOk = nvdao.isUsernameAndPasswordValid(username, passwords);
		if (isOk) {
			NhanVien user = nvdao.selectByName(username);
			session.setAttribute("username", username);
			session.setAttribute("passwords", passwords);
			session.setAttribute("tennv", user.getHo_va_ten());
			m.addAttribute("msg", "Đăng nhập thành công!!!");
			return "redirect:/admin";

		} else {
			m.addAttribute("msg", "Dăng nhập thất bại!!!");
			return "/login";

		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// Xóa thông tin đăng nhập khỏi session
		session.removeAttribute("username");
		session.removeAttribute("passwords");
		// Điều hướng về trang đăng nhập
		return "redirect:/admin/login";
	}

}
