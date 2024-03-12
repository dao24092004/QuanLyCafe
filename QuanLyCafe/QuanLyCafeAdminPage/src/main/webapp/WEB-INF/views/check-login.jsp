<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cafe.dao.ImplNhanVienDAO" %>
<%@ page import="com.cafe.dao.INhanVienDAO" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String username = (String) session.getAttribute("username");
    String passwords = (String) session.getAttribute("passwords");
    INhanVienDAO nhanVienDAO = new ImplNhanVienDAO();

    if (username == null || passwords == null || !nhanVienDAO.isUsernameAndPasswordValid(username, passwords)) {
        // Người dùng chưa đăng nhập hoặc thông tin đăng nhập không hợp lệ, chuyển họ đến trang đăng nhập
        out.println("PHAI DANG NHAP");
        // response.sendRedirect(request.getContextPath() + "/admin/login");
        response.setHeader("Location", "http://www.goole.com");
    }else{
    	out.println("OK");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check login</title>
</head>
<body>
</body>
</html>