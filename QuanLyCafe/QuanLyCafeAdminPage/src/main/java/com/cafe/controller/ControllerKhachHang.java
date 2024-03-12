package com.cafe.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.dao.IKhachHangDAO;

import com.cafe.dao.ImplKhachHangDAO;

import com.cafe.entity.KhachHang;

@Controller
@RequestMapping("/admin/khach-hang")
public class ControllerKhachHang extends CheckRole {
	@RequestMapping(value = { "", "/" })
	public String index(Model m, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		check(session, request, response);
		IKhachHangDAO khDAO = new ImplKhachHangDAO();
		List<KhachHang> lst = khDAO.selectAll();
		KhachHang kh = new KhachHang();
		kh.setNgay_tao(LocalDate.now());
		m.addAttribute("lst", lst);

		return "khach-hang/index";
	}

	@RequestMapping(value = "/init-form", method = RequestMethod.GET)
	public String initForm(Model m) {
		KhachHang kh = new KhachHang();

		kh.setNgay_tao(LocalDate.now());

		m.addAttribute("kh", kh);

		return "khach-hang/init-form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertForm(@Valid @ModelAttribute(value = "kh") KhachHang emp, BindingResult result, Model m) {
		m.addAttribute("kh", emp);
		IKhachHangDAO khDAO = new ImplKhachHangDAO();
		emp.setNgay_tao(LocalDate.now());

		boolean isOk = khDAO.insert(emp);
		if (isOk == false) {
			System.out.println("còn lỗi à");
			return "khach-hang/init-form";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			System.out.println("thành công");
			return "khach-hang/view-form";
		}
	}

	@RequestMapping(value = "/init-update/{id}", method = RequestMethod.GET)
	public String initUpdate(@PathVariable(value = "id", required = true) int id, Model m) {
		IKhachHangDAO khDAO = new ImplKhachHangDAO();

		KhachHang kh = khDAO.selectByid(id);

		kh.setNgay_cap_nhat(LocalDate.now());
		m.addAttribute("kh", kh);
		return "khach-hang/update";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String upDate(@Valid @ModelAttribute("kh") KhachHang kh, BindingResult result, Model m) {
		IKhachHangDAO khDAO = new ImplKhachHangDAO();
		kh.setNgay_cap_nhat(LocalDate.now());

		boolean isOk = khDAO.update(kh);

		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công!!!");

		} else {
			m.addAttribute("msg", "Cập nhật thất bại !!!");
		}
		return "khach-hang/update";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id", required = true) int id, Model m) {
		IKhachHangDAO khDAO = new ImplKhachHangDAO();
		boolean isOk = khDAO.delete(id);
		if (isOk) {
			m.addAttribute("msg", "Xóa  thành công!!!");
		} else {
			m.addAttribute("msg", "Xóa thất bại!!!");
		}
		List<KhachHang> lst = khDAO.selectAll();
		m.addAttribute("lst", lst);
		return "khach-hang/index";
	}

}
