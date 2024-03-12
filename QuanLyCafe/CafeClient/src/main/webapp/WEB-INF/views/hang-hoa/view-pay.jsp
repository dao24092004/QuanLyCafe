<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thông tin thanh toán</title>
</head>
<body>
	<div id="page-container">


		<h2>Thông tin thanh toán</h2>
		<hr>
		<a class="link" href="${rootpath}">Trang chủ</a>|| <a class="link"
			href="${rootpath}nhan-vien">Trang nhân viên</a>|| <a class="link"
			href="${rootpath}khach-hang">Trang khách hàng</a>|| <a
			href="${rootpath}hang-hoa/cart">Giỏ hàng</a>

		<hr>
		<b style="color: red;">${msg}</b>

		<table border="1">

			<tr>
				<th>Tên khách hàng</th>
				<td>${hd.hdkhachhang.ten}</td>
			</tr>
			<tr>
				<th>Số điện thoại</th>
				<td>${hd.hdkhachhang.dien_thoai}</td>
			</tr>
			<tr>
				<th>Tên nhân viên</th>
				<td>${hd.nhanvien.ho_va_ten}</td>

			</tr>
			<tr>
				<th>Ngày tạo</th>
				<td>${hd.ngay_tao}</td>
			</tr>

			<tr>
				<th>Tổng tiền</th>
				<td><fmt:formatNumber value="${totalPrice}" type="CURRENCY "
						currencyCode="VND" pattern="#,##0₫" /></td>
			</tr>
			<tr>
				<th>Trạng thái</th>
				<td>${hd.trang_thai ==1 ? "Đang làm": "Đã giao hàng"}</td>
			</tr>



		</table>

	</div>
</body>
</html>