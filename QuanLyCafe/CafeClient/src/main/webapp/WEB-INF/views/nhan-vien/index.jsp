<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<sp:url value="nhan-vien" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
<title>Nhân viên</title>
</head>
<body>
	<h1 id="header">Trang nhân viên</h1>
	<hr>
	<nav id="navigation">
		<a href="${rootpath}">Trang chủ</a>|| <a
			href="${rootpath}khach-hang">Trang khách hàng</a>|| <a
			href="${rootpath}/hang-hoa/cart">Giỏ hàng</a>
	</nav>
	<table id="data-table" class="custom-table" border="1">
		<tr>
			<th>Mã nhân viên</th>
			<th>Tên nhân viên</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>Ngày vào làm</th>
			<th>Số điện thoại di động</th>
			<th>Số điện thoại gia đình</th>
			<th>Email</th>
			<th>Địa chỉ</th>
			<th>Mã phân quyền</th>
			<th>Lương cơ bản</th>
			<th>Tên đăng nhập</th>
			<th>Mật khẩu đăng nhập</th>
			<th>Ghi chú</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>


		</tr>
		<c:forEach items="${lst}" var="nv">
			<tr>
				<td>${nv.id}</td>
				<td>${nv.ho_va_ten}</td>
				<td>${nv.gioi_tinh ==1 ?"Nam":"Nữ"}</td>
				<td><fmt:formatDate type="date" dateStyle="FULL"
						value="${nv.ngay_sinh}" /></td>
				<td><fmt:formatDate type="date" dateStyle="FULL"
						value="${nv.ngay_vao_lam}" /></td>

				<td>${nv.di_dong}</td>
				<td>${nv.dt_gia_dinh}</td>
				<td>${nv.email}</td>
				<td>${nv.dia_chi}</td>
				<td>${nv.id_phan_quyen}</td>

				<td><fmt:formatNumber type="CURRENCY"
						value="${nv.luong_co_ban}" pattern="#,##đ" /></td>
				<td>${nv.username}</td>
				<td>${nv.passwords}</td>
				<td>${nv.ghi_chu}</td>
				<td>${nv.trang_thai ==1?"Đang làm việc" : "Đã nghỉ việc"}</td>
				<td align="center"><a
					href="${rootpath}nhan-vien/init-update/${nv.id}"><img
						alt="Update" src="${rootpath}/assets/img/update.png" /></a></td>


			</tr>
		</c:forEach>

	</table>




	</table>
</body>
</html>