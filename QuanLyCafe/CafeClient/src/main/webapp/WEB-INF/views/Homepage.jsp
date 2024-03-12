<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/hang-hoa" var="path"></sp:url>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hàng hóa</title>
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
	<script type="text/javascript">
	function deleteHangHoa(name, id) {
		let isDel = confirm(" Tên hàng hóa [" + name + "] có mã là " + id)
		if (isDel) {
			window.location = ("${rootpath}admin/hang-hoa/delete/" + id);
		}

	}
</script>
</head>
<body>
	<h1 id="header">Trang chủ</h1>
	<hr>
	<nav id="navigation">
		<a href="${rootpath}nhan-vien">Trang nhân viên</a>|| <a
			href="${rootpath}khach-hang">Trang khách hàng</a> ||
			<a href="${path}/cart">Giỏ
			hàng</a>
	</nav>


	<hr>
	<b id="message" style="color: red;">${msg}</b>
	
	 <table id="data-table" class="custom-table" border="1">
		<tr>
			<th>Mã hàng hóa</th>
			<th>Tên hàng hóa</th>

			<th>Tên chủng loại</th>

			<th>Đơn vị tính</th>

			<th>Nhà cung cấp</th>

			<th>Giá bán</th>

			<th>Ghi chú</th>
			<th>Thêm vào giỏ hàng</th>


		</tr>
		<c:forEach items="${lst}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.ten_hang_hoa}</td>

				<td>${item.chungloai.ten}</td>

				<td>${item.donvi.ten_don_vi}</td>

				<td>${item.nhacung.ten_nhacc}</td>

				<td><fmt:formatNumber value="${item.gia_xuat}" type="CURRENCY"
						currencyCode="VND" pattern="#,##0₫" /></td>

				<td>${item.ghi_chu}</td>
				<td align="center"><a
					href="${rootpath}hang-hoa/AddtoCart/${item.id}"><img
						alt="Add to Cart" src="${rootpath}/assets/img/gio-hang.png" /></a></td>
				<!-- 				<td align="center"><img alt="Delete" -->
				<%-- 					src="${rootpath}/assets/img/delete1.png" --%>
				<%-- 					onclick="deleteHangHoa('${item.ten_hang_hoa}',${item.id})" /></td> --%>

			</tr>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>