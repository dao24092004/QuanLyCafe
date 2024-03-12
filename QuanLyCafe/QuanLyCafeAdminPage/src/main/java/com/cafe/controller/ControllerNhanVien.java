package com.cafe.controller;


import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.IPhanQuyenDAO;
import com.cafe.dao.ImplNhanVienDAO;
import com.cafe.dao.ImplPhanQuyenDAO;
import com.cafe.entity.NhanVien;
import com.cafe.entity.PhanQuyen;



@Controller
@RequestMapping("/admin/nhan-vien")
public class ControllerNhanVien extends CheckRole{
	@RequestMapping(value = "/init-form", method = RequestMethod.GET)
	public String initForm(Model m) {
		NhanVien nv = new NhanVien();
		IPhanQuyenDAO pqDAO= new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = pqDAO.selectAll();
		m.addAttribute("lstpq", lstpq);
		m.addAttribute("nv", nv);

		return "nhan-vien/init-form";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertForm(@Valid @ModelAttribute(value = "nv") NhanVien emp, BindingResult result, Model m) {
		m.addAttribute("nv", emp);
		INhanVienDAO nvDAO = new ImplNhanVienDAO();
		IPhanQuyenDAO pqDAO= new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = pqDAO.selectAll();
		m.addAttribute("lstpq", lstpq);
		boolean isOk = nvDAO.insert(emp);
		if (isOk == false) {
			System.out.println("còn lỗi à");
			return "nhan-vien/init-form";
		} else {
			m.addAttribute("msg", "Thêm mới thành công");
			System.out.println("thành công");
			return "nhan-vien/view-form";
		}
	}
	@RequestMapping(value = "/init-update/{id}",method = RequestMethod.GET)
	public String initUpdate(@PathVariable(value = "id",required = true) int id, Model m) 
	{
		INhanVienDAO nvDAO = new ImplNhanVienDAO();
		NhanVien nv= nvDAO.selectByid(id);
		m.addAttribute("nv", nv);
		return "nhan-vien/update";
		
		
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String upDate(@Valid @ModelAttribute("nv") NhanVien nv,BindingResult result , Model m)
	{
		INhanVienDAO nvDAO = new ImplNhanVienDAO();
		String msgerr="";
		boolean isOk = nvDAO.update(nv,msgerr);
		IPhanQuyenDAO pqDAO= new ImplPhanQuyenDAO();
		List<PhanQuyen> lstpq = pqDAO.selectAll();
		m.addAttribute("lstpq", lstpq);
		System.out.println("form: "+ msgerr);
		if (isOk) {
			m.addAttribute("msg", "Cập nhật thành công!!!");
			
		} else {
			m.addAttribute("msg", "Cập nhật thất bại do!!!" + msgerr);
		}
		return "nhan-vien/update";
	}
	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id",required = true) int id,Model m){
		INhanVienDAO nvDAO = new ImplNhanVienDAO();
		boolean isOk = nvDAO.delete(id);
		if (isOk) {
			m.addAttribute("msg", "Xóa  thành công!!!");
		} else {
			m.addAttribute("msg", "Xóa thất bại!!!");
		}
		List<NhanVien> lst = nvDAO.selectAll();
		m.addAttribute("lst", lst);
		return "nhan-vien/index";
	}
	@RequestMapping(value =  "/search",method = RequestMethod.POST)
	public String search(@RequestParam(name = "txtSearch")String search,Model m) {
		INhanVienDAO nvDAO = new ImplNhanVienDAO();
		List<NhanVien> lst = nvDAO.search(search);
		m.addAttribute("lst", lst);
		if (lst == null) {
			m.addAttribute("msg", "Không tìm thấy nhân viên");
		}
		
		return "index";
	}
	
	

}
