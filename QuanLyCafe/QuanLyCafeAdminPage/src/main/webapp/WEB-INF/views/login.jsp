<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/login" var="path"></sp:url>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Trang Đăng Nhập</title>
    <link href="<c:url value="/assets/css/login.css" />"
	rel="stylesheet">

</head>
<body>

<div class="container">
    <h1>Đăng nhập</h1>

    <form id="loginForm" action="${path}" method="post">
        <label for="username">Tên người dùng:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="passwords" required>

        <button type="submit">Đăng nhập</button>
    </form>
</div>

</body>
</html>





