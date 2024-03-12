<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sp:url value="/admin/khach-hang" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">

<title>Thêm mới khách hàng</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<h1>Thông tin khách hàng mới</h1>
		<hr>
		<nav>
			<a href="${rootpath}" class="nav-link">Trang chủ</a>|| <a
				href="${path}" class="nav-link">Quản lý khách hàng</a>
		</nav>
		<hr>
		<b id="error-msg" class="box-err">${msg}>${msg}</b>

		<section class="info-section">
			<table class="info-table">
				<tr>
					<th>Họ</th>
					<td>${kh.ho}</td>
				</tr>
				<tr>
					<th>Tên khách hàng</th>
					<td>${kh.ten}</td>
				</tr>
				<tr>
					<th>Giới tính</th>
					<td>${kh.gioi_tinh ==1 ? "Nam":"Nữ"}</td>

				</tr>
				<tr>
					<th>Ngày sinh</th>
					<td><fmt:formatDate type="date" dateStyle="MEDIUM"
							value="${kh.ngay_sinh}" /></td>
				</tr>
				<tr>
					<th>Số điện thoại</th>
					<td>${kh.dien_thoai}</td>
				</tr>
				<tr>
					<th>Email</th>
					<td>${kh.email}</td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td>${kh.ngay_tao}</td>

				</tr>
				<tr>
					<th>Ngày cập nhật</th>
					<td>${kh.ngay_cap_nhat}</td>

				</tr>

				<tr>
					<th>Trạng thái</th>
					<td>${kh.trang_thai == 1 ? "Hoạt động" :"Không hoạt động"}</td>
				</tr>




			</table>
		</section>
	</header>
</body>
</html>