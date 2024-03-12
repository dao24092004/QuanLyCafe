<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/hang-hoa" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />" rel="stylesheet">
<title>Thêm mới hàng hóa</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>


	<header>
		<h1>Thông tin hàng hóa</h1>
		<hr>
		<nav>
			<a href="${rootpath}" class="nav-link">Trang chủ</a> || <a
				href="${path}" class="nav-link">Quản lý hàng hóa</a>
		</nav>
		<hr>
		<b id="error-msg" class="box-err">${msg}</b>
	</header>

	<section class="info-section">
		<table class="info-table">
			 <tr>
			<th> Mã vạch</th>
			<td> ${hh.bar_code}</td>
			</tr>
			<tr>
				<th>Tên Hàng hóa</th>
				<td>${hh.ten_hang_hoa}</td>
			</tr>
			<tr>
				<th> ID chủng loại</th>
				<td>${hh.chungloai.id}</td>
			</tr>
			
			<tr>
				<th>ID Đơn vị</th>
				<td>${hh.donvi.id}</td>
			</tr>
			
			<tr>
				<th>ID Đơn vị cung cấp</th>
				<td>${hh.nhacung.id}</td>
			</tr>
			
			<tr>
				<th>Số lượng</th>
				<td>${hh.so_luong}</td>
			</tr>
			<tr>
				<th>Giá nhập</th>
				<td>${hh.gia_nhap}</td>
			</tr>
			<tr>
				<th>Giá xuất</th>
				<td>${hh.gia_xuat}</td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${hh.ngay_tao}</td>

			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${hh.ngay_cap_nhat}</td>

			</tr>

			<tr>
				<th>Ghi chú</th>
				<td>${hh.ghi_chu}</td>
			</tr>




		</table>
	</section>
</body>


</html>