<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/admin" var="rootpath"></sp:url>
<sp:url value="/" var="path"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
<script type="text/javascript">
	function deleteNhanVien(name , id) 
	{
		let isDel = confirm(" Tên nhân viên [" + name + "] có mã là " + id)
		if (isDel) 
		{
			window.location = ("${rootpath}admin/nhan-vien/delete/" + id);
		}
		
	}
</script>

<title>Trang quản lý quán cafe</title>

</head>
<body>
	<b>${msg}</b>

	<div id="page-container">
		<h1 id="header">Trang quản lý</h1>
		<hr>

		<nav id="navigation">
			<a href="${rootpath}">Trang chủ</a>|| <a
				href="${rootpath}/nhan-vien/init-form">Thêm nhân viên</a>|| <a
				href="${rootpath}/hang-hoa">Quản lý hàng hóa</a> || <a
				href="${rootpath}/nha-cung-cap">Quản lý nhà cung cấp</a> || <a
				href="${rootpath}/khach-hang">Quản lý khách hàng</a> || <a>Xin
				chào, ${sessionScope.tennv}!</a><a
				href="${pageContext.request.contextPath}/admin/logout">(Đăng
				xuất)</a>
		</nav>



		<hr>
		<b id="message">${msg}</b>
		<form action="${path}admin/nhan-vien/search" method="post"
			class="search-form">
			<input class="form-input" type="text" name="txtSearch"
				placeholder="Nguyễn Văn A"> <input class="form-submit"
				type="submit" value="Tìm kiếm" />
		</form>
		<hr>

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
				<th>Xóa</th>

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
					<td>${nv.phanquyen.id}</td>

					<td><fmt:formatNumber type="CURRENCY"
							value="${nv.luong_co_ban}" currencyCode="VND" pattern="#,##0₫" /></td>
					<td>${nv.username}</td>
					<td>${nv.passwords}</td>
					<td>${nv.ghi_chu}</td>
					<td>${nv.trang_thai ==1?"Đang làm việc" : "Đã nghỉ việc"}</td>
					<td align="center"><a
						href="${path}admin/nhan-vien/init-update/${nv.id}"><img
							alt="Update" src="${path}/assets/img/update.png" /></a></td>
					<td align="center"><img alt="Delete"
						src="${path}/assets/img/delete.png"
						onclick="deleteNhanVien('${nv.ho_va_ten}',${nv.id})" /></td>

				</tr>
			</c:forEach>

		</table>


	</div>

</body>
</html>