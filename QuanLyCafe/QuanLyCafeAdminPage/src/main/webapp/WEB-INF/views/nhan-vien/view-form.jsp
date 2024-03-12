<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<sp:url value="/admin/nhan-vien" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thông tin nhân viên mới</title>
</head>
<body>
	<header>
		<h1>Thông tin nhân viên mới</h1>
		<hr>
		<nav>
			<a href="${rootpath}" class="nav-link">Quản lý nhân viên</a>
		</nav>
		<hr>
		<b id="error-msg" class="box-err">${msg}</b>
	</header>
	<section class="info-section">
		<table class="info-table">

			<tr>
				<th>Tên Nhân viên</th>
				<td>${nv.ho_va_ten}</td>
			</tr>
			<tr>
				<th>Giới tính</th>
				<td>${nv.gioi_tinh ==1 ? "Nam":"Nữ"}</td>
			</tr>
			<tr>
				<th>Ngày sinh</th>
				<td><fmt:formatDate type="date" dateStyle="FULL"
						value="${nv.ngay_sinh}" /></td>

			</tr>
			<tr>
				<th>Ngày vào làm</th>
				<td><fmt:formatDate type="date" dateStyle="FULL"
						value="${nv.ngay_vao_lam}" /></td>
			</tr>
			<tr>
				<th>Số điện thoại</th>
				<td>${nv.di_dong}</td>
			</tr>
			<tr>
				<th>Số điện thoại gia đình</th>
				<td>${nv.dt_gia_dinh}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${nv.email}</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${nv.dia_chi}</td>
			</tr>
			<tr>
				<th>ID Phân quyền</th>
				<td>${nv.phanquyen.id}</td>
			</tr>
			<tr>
				<th>Lương cơ bản</th>
				<td>${nv.luong_co_ban}</td>
			</tr>
			<tr>
				<th>UserName</th>
				<td>${nv.username}</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>${nv.passwords}</td>
			</tr>
			<tr>
				<th>Ghi chú</th>
				<td>${nv.ghi_chu}</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${nv.trang_thai ==1 ? "Đang làm việc": "Đã nghỉ việc"}</td>
			</tr>



		</table>
	</section>
</body>
</html>