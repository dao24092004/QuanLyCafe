package com.cafe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.IPhanQuyenDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.dao.ImplPhanQuyenDAO;
import com.cafe.entity.NhanVien;
import com.cafe.entity.PhanQuyen;



@Controller
@RequestMapping("/admin")
public class Admin extends CheckRole {
	@RequestMapping(value = { "","/"})
	public String index(Model m,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws IOException {
	check(session, request, response)	;
	INhanVienDAO nvDAO = new ImplNhanVienDAO();
	List<NhanVien> lst = nvDAO.selectAll();
	IPhanQuyenDAO pqDAO= new ImplPhanQuyenDAO();
	List<PhanQuyen> lstpq = pqDAO.selectAll();
	m.addAttribute("lstpq", lstpq);
	m.addAttribute("lst", lst);
		
		return "index";
	}
	
}
