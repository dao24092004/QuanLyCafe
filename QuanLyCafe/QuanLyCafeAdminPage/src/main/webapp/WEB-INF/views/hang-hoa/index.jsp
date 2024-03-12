<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/admin/hang-hoa" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
<title>Quản lý hàng hóa</title>
<script type="text/javascript">
	function deleteHangHoa(name , id) 
	{
		let isDel = confirm(" Tên hàng hóa [" + name + "] có mã là " + id)
		if (isDel) 
		{
			window.location = ("${rootpath}admin/hang-hoa/delete/" + id);
		}
		
	}


</script>
</head>
<body>
	<h1 id="header">Trang quản lý hàng hóa</h1>
	<hr>
	<nav id="navigation">
		<a href="${rootpath}admin/nha-cung-cap">Quản lý nhà cung cấp</a> || <a
			href="${rootpath}admin/khach-hang">Quản lý khách hàng</a> || <a
			href="${path}/init-form">Thêm mới hàng hóa</a>|| <a>Xin chào,
			${sessionScope.tennv}!</a><a
			href="${pageContext.request.contextPath}/admin/logout">(Đăng
			xuất)</a>
	</nav>
	<hr>
	<b id="message" style="color: red;">${msg}</b>
	<form action="${path}/search" method="get">
		<input class="form-input" name="txtSearch" type="text" /> <input
			class="form-submit" type="submit" value="Tìm kiếm" />
	</form>
	<!-- Form thống kê -->
	<form id="search-form" id="statistic-form" action="${path}/thong-ke"
		method="post">
		<label for="ngay">Ngày:</label> <input type="number" name="ngay"
			min="1" max="31" required /> <label for="thang">Tháng:</label> <input
			type="number" name="thang" min="1" max="12" required /> <label
			for="nam">Năm:</label> <input type="number" name="nam" min="1900"
			max="2100" required /> <input class="form-submit" type="submit"
			value="Thống kê" />
	</form>
	<table id="data-table" class="custom-table" border="1">
		<tr>
			<th>Mã hàng hóa</th>
			<th>Tên hàng hóa</th>
			<th>Mã chủng loại</th>
			<th>Tên chủng loại</th>
			<th>Mã đơn vị tính</th>
			<th>Đơn vị tính</th>
			<th>Mã nhà cung cấp</th>
			<th>Nhà cung cấp</th>
			<th>Số Lượng</th>
			<th>Giá nhập</th>
			<th>Giá bán</th>
			<th>Ngày tạo</th>
			<th>Ngày cập nhật</th>
			<th>Ghi chú</th>
			<th>Cập nhật</th>
			<th>Xóa</th>

		</tr>
		<c:forEach items="${lst}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.ten_hang_hoa}</td>
				<td>${item.chungloai.id}</td>
				<td>${item.chungloai.ten}</td>
				<td>${item.donvi.id}</td>
				<td>${item.donvi.ten_don_vi}</td>
				<td>${item.nhacung.id}</td>
				<td>${item.nhacung.ten_nhacc}</td>
				<td><fmt:formatNumber value="${item.so_luong}" pattern="###" /></td>
				<td><fmt:formatNumber value="${item.gia_nhap}" type="CURRENCY"
						currencyCode="VND" pattern="#,##0₫" /></td>
				<td><fmt:formatNumber value="${item.gia_xuat}" type="CURRENCY"
						currencyCode="VND" pattern="#,##0₫" /></td>
				<td>${item.ngay_tao}</td>
				<td>${item.ngay_cap_nhat}</td>
				<td>${item.ghi_chu}</td>
				<td align="center"><a
					href="${rootpath}admin/hang-hoa/init-update/${item.id}"><img
						alt="Update" src="${rootpath}/assets/img/update1.png" /></a></td>
				<td align="center"><img alt="Delete"
					src="${rootpath}/assets/img/delete1.png"
					onclick="deleteHangHoa('${item.ten_hang_hoa}',${item.id})" /></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>