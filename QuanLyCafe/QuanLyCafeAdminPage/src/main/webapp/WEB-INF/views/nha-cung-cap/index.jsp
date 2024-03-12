<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/admin/nha-cung-cap" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">

<title>Nhà cung cấp</title>
<script type="text/javascript">
	function deleteNhaCungCap(name , id) 
	{
		let isDel = confirm(" Tên nhà cung cấp [" + name + "] có mã là " + id)
		if (isDel) 
		{
			window.location = ("${rootpath}admin/nha-cung-cap/delete/" + id);
		}
		
	}
</script>
</head>
<body>

	<h1 id="header">Nhà cung cấp</h1>
	<hr>
	<nav id="navigation">
		<a href="${rootpath}admin">Trang chủ</a>|| <a
			href="${rootpath}admin/khach-hang">Quản lý khách hàng</a> || <a
			href="${rootpath}admin/hang-hoa">Quản lý hàng hóa</a>|| <a
			href="${path}/init-form">Thêm nhà cung cấp</a>|| <a>Xin chào,
			${sessionScope.tennv}!</a><a
			href="${pageContext.request.contextPath}/admin/logout">(Đăng
			xuất)</a>

	</nav>


	<table id="data-table" class="custom-table" border="1">
		<tr>
			<th>Mã nhà cung cấp</th>
			<th>Tên nhà cung cấp</th>
			<th>Địa chỉ</th>
			<th>Số điện thoại 1</th>
			<th>Số điện thoại 2</th>
			<th>Fax</th>
			<th>Email</th>
			<th>Website</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Tax code</th>
			<th>Ghi chú</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach items="${lst}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.ten_nhacc}</td>
				<td>${item.dia_chi}</td>
				<td>${item.sdt1}</td>
				<td>${item.sdt2}</td>
				<td>${item.fax}</td>
				<td>${item.email}</td>
				<td>${item.website}</td>
				<td>${item.gay_tao}</td>
				<td>${item.ngay_cap_nhat}</td>
				<td>${item.tax_code}</td>
				<td>${item.ghi_chu}</td>
				<td>${item.trang_thai ==1 ?"Đang Hoạt Động":"Không Hoạt Động"}</td>
				<td align="center"><a
					href="${rootpath}admin/nha-cung-cap/init-update/${item.id}"><img
						alt="Update" src="${rootpath}assets/img/update1.png" /></a></td>
				<td align="center"><img alt="Delete"
					src="${rootpath}/assets/img/delete1.png"
					onclick="deleteNhaCungCap('${item.ten_nhacc}',${item.id})" /></td>

			</tr>
		</c:forEach>
	</table>



</body>
</html>