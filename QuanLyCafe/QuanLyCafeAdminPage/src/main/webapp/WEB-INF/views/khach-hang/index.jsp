<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/admin/khach-hang" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
<title>Quản lý khách hàng</title>
<script type="text/javascript">
function deleteKhachHang(name , id) 
{
	let isDel = confirm(" Tên khách hàng [" + name + "] có mã là " + id)
	if (isDel) 
	{
		window.location = ("${rootpath}admin/khach-hang/delete/" + id);
	}
	
}

</script>
</head>
<body>
	<h1 id="header">Trang quản lý khách hàng</h1>
	<hr>
	<nav id="navigation">
		<a href="${rootpath}admin">Trang chủ</a>|| <a
			href="${rootpath}admin/nha-cung-cap">Quản lý nhà cung cấp</a> || <a
			href="${rootpath}admin/hang-hoa">Quản lý hàng hóa</a>||<a
			href="${path}/init-form">Thêm mới khách hàng</a>|| <a>Xin chào,
			${sessionScope.tennv}!</a><a
			href="${pageContext.request.contextPath}/admin/logout">(Đăng
			xuất)</a>
	</nav>
	<hr>
	<b id="message" style="color: red;">${msg}</b>
	<hr>
	<table id="data-table" class="custom-table" border="1">
		<tr>
			<th>Mã khách hàng</th>
			<th>Họ</th>
			<th>Tên khách hàng</th>
			<th>Giới tính</th>
			<th>Ngày sinh</th>
			<th>Số điện thoại</th>
			<th>Địa chỉ</th>
			<th>Email</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lst}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.ho}</td>
				<td>${item.ten}</td>
				<td>${item.gioi_tinh ==1 ? "Nam": "Nữ"}</td>
				<td><fmt:formatDate type="date" dateStyle="MEDIUM"
						value="${item.ngay_sinh}" /></td>
				<td>${item.dien_thoai}</td>
				<td>${item.dia_chi}</td>
				<td>${item.email}</td>
				<td>${item.ngay_tao}</td>
				<td>${item.ngay_cap_nhat}</td>
				<td>${item.trang_thai ==1 ? "Đang hoạt động" : "Không hoạt động"}</td>
				<td align="center"><a
					href="${rootpath}admin/khach-hang/init-update/${item.id}"><img
						alt="Update" src="${rootpath}assets/img/update1.png" /></a></td>
				<td align="center"><img alt="Delete"
					src="${rootpath}/assets/img/delete1.png"
					onclick="deleteKhachHang('${item.ten}',${item.id})" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>