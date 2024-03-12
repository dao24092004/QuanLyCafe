<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="rootpath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Xin chào quý khách</h1>
<hr>
<a href="${rootpath}rest/nhan-vien">Trang nhân viên</a>
<a href="${rootpath}rest/khach-hang">Trang khach hang</a>
</body>
</html>