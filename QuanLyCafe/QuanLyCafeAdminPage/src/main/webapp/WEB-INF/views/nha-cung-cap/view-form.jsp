<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/nha-cung-cap" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thêm mới nhà cung cấp</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<header>
		<h1>Thông tin nhà cung cấp</h1>
		<nav>
			<a href="${rootpath}" class="nav-link">Trang chủ</a>|| <a
				href="${path}" class="nav-link">Nhà cung cấp</a>
		</nav>
		<hr>
		<b id="error-msg" class="box-err">${msg}</b>
	</header>
	<section class="info-section">
		<table class="info-table">

			<tr>
				<th>Tên nhà cung cấp</th>
				<td>${ncc.ten_nhacc}</td>
			</tr>
			<tr>
				<th>Địa chỉ</th>
				<td>${ncc.dia_chi}</td>
			</tr>
			<tr>
				<th>Số điện thoại 1</th>
				<td>${ncc.sdt1}</td>
			</tr>
			<tr>
				<th>Số điện thoại 2</th>
				<td>${ncc.sdt2}</td>
			</tr>
			<tr>
				<th>Fax</th>
				<td>${ncc.fax}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${ncc.email}</td>
			</tr>
			<tr>
				<th>Trang chủ nhà cung cấp</th>
				<td>${ncc.website}</td>
			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${ncc.gay_tao}</td>
			</tr>
			<tr>
				<th>Ngày cập nhật</th>
				<td>${ncc.ngay_cap_nhat}</td>
			</tr>
			<tr>
				<th>Mã số thuế</th>
				<td>${ncc.tax_code}</td>
			</tr>

			<tr>
				<th>Ghi chú</th>
				<td>${ncc.ghi_chu}</td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${ncc.trang_thai == 1 ? "Hoạt động": "Không hoạt động"}</td>
			</tr>



		</table>
	</section>

</body>
</html>