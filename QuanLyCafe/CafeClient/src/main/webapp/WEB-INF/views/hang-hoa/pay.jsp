<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thông tin giao dịch</title>
</head>
<body>
	<div id="page-container">
		<h1>Thông tin giao dịch</h1>
		<hr>
		<a class="link" href="${rootpath}nhan-vien">Trang nhân viên</a>|| <a
			class="link" href="${rootpath}khach-hang">Trang khách hàng</a>|| <a
			class="link" href="${rootpath}">Trang hàng hóa</a>||
			 <a
			href="${rootpath}hang-hoa/cart">Giỏ hàng</a>
		<hr>
		<b>${msg}</b>

		<spf:form action="${rootpath}/hang-hoa/pay" method="post" modelAttribute="hd">
			<table border="1">

				<tr>
					<th>Tên khách hàng</th>
					<td><spf:input path="hdkhachhang.ten" type="text"
							placeholder=" Anh" /></td>
				</tr>


				<tr>
					<th>Số điện thoại</th>
					<td><spf:input path="hdkhachhang.dien_thoai" type="text" />
				</tr>
				<tr>
					<th>Mã nhân viên</th>
					<td><spf:input path="nhanvien.id" type="number" /></td>
				</tr>
				<tr>
					<th>Tên nhân viên</th>
					<td><spf:input path="nhanvien.ho_va_ten" type="text" /></td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td><spf:input path="ngay_tao" type="date" /></td>
				</tr>



				<tr>

					<th></th>
					<td><input type="submit" value="Thanh Toán" /></td>
				</tr>


			</table>
		</spf:form>

	</div>
</body>
</html>