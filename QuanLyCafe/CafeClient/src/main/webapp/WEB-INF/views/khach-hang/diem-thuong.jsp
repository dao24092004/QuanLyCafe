<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/khach-hang" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />" rel="stylesheet">

<title>Quản lý khách hàng</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<h1>Trang quản lý khách hàng</h1>
		<hr>
		<nav>
			<a class="nav-link" href="${rootpath}">Trang chủ</a>|| <a
				class="nav-link" href="${rootpath}nhan-vien">Trang nhân viên</a>|| <a
				class="nav-link" href="${rootpath}/hang-hoa/cart">Giỏ hàng</a>

		</nav>
		<hr>
		<b id="error-msg" class="box-err" style="color: red;">${msg}</b>
		<hr>
	</header>
	<section class="info-section">
		<table class="info-table">

			<tr>
				<th>Mã điểm thưởng</th>
				<td>${dt.id}</td>
			</tr>
			<tr>
				<th>Tên khách hàng</th>
				<td>${dt.khachhang.ten}</td>
			</tr>
			<tr>
				<th>Số điện thoại</th>
				<td>${dt.khachhang.dien_thoai}</td>
			</tr>
			<tr>
				<th>Nội dung</th>
				<td>${dt.noi_dung}</td>
			</tr>
			<tr>
				<th>Fax</th>
				<td>${dt.diem}</td>
			</tr>


		</table>
	</section>

</body>
</html>