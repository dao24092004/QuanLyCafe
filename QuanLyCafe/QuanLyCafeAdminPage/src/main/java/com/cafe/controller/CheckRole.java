package com.cafe.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe.dao.INhanVienDAO;
import com.cafe.dao.ImplNhanVienDAO;

public class CheckRole {
	public void check(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = (String) session.getAttribute("username");
		String passwords = (String) session.getAttribute("passwords");
		INhanVienDAO nhanVienDAO = new ImplNhanVienDAO();

		if (username == null || passwords == null || !nhanVienDAO.isUsernameAndPasswordValid(username, passwords)) {
			// Người dùng chưa đăng nhập hoặc thông tin đăng nhập không hợp lệ, chuyển họ
			// đến trang đăng nhập
			// out.println("PHAI DANG NHAP");
			System.out.println("phai dang nhap");
			response.sendRedirect(request.getContextPath() + "/admin/login");
			// response.setHeader("Location", "http://www.goole.com");
		} else {
			// out.println("OK");
			System.out.println("ok");
		
			
		}
	}

}
