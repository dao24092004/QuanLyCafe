package com.cafe.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe.dao.INhaCungCapDAO;
import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplNhaCungCapDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.entity.NhaCungCap;
import com.cafe.entity.NhanVien;

@Controller
@RequestMapping("/admin/nha-cung-cap")
public class ControllerNhaCungCap extends CheckRole {
	@RequestMapping(value = { "", "/" })
	public String index(Model m, HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		check(session, request, response);
		INhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		List<NhaCungCap> lst = nccDAO.selectAll();
		NhaCungCap ncc = new NhaCungCap();
		ncc.setGay_tao(LocalDate.now());
		m.addAttribute("lst", lst);
		return "nha-cung-cap/index";
	}

	@RequestMapping(value = "/init-form", method = RequestMethod.GET)
	public String initForm(Model m) {
		NhaCungCap ncc = new NhaCungCap();
		ncc.setGay_tao(LocalDate.now());

		m.addAttribute("ncc", ncc);

		return "nha-cung-cap/init-form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertForm(@Valid @ModelAttribute(value = "ncc") NhaCungCap nhacc, BindingResult result, Model m) {
		m.addAttribute("ncc", nhacc);
		ImplNhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		nhacc.setGay_tao(LocalDate.now());

		System.out.println("Insert vào đây");
		boolean isOk = nccDAO.insert(nhacc);
		if (isOk == false) {
			System.out.println("loi day khoong");
			return "nha-cung-cap/init-form";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			return "nha-cung-cap/view-form";
		}
	}

	@RequestMapping(value = "/init-update/{id}", method = RequestMethod.GET)
	public String initUpdate(@PathVariable(value = "id", required = true) int id, Model m) {
		INhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		NhaCungCap ncc = nccDAO.selectByid(id);
		ncc.setNgay_cap_nhat(LocalDate.now());
		m.addAttribute("ncc", ncc);
		return "nha-cung-cap/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String upDate(@Valid @ModelAttribute("ncc") NhaCungCap ncc, BindingResult result, Model m) {
		INhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		String msgerr = "";
		ncc.setNgay_cap_nhat(LocalDate.now());

		boolean isOk = nccDAO.update(ncc, msgerr);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công!!!");
		} else {
			m.addAttribute("msg", "Cập nhật thất bại!!! do " + msgerr);
		}
		return "nha-cung-cap/update";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id", required = true) int id, Model m) {
		INhaCungCapDAO nccDAO = new ImplNhaCungCapDAO();
		boolean isOk = nccDAO.delete(id);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công!!!");
		} else {
			m.addAttribute("msg", "Cập nhật thất bại!!!");
		}
		List<NhaCungCap> lst = nccDAO.selectAll();
		m.addAttribute("lst", lst);
		return "nha-cung-cap/index";
	}

}
