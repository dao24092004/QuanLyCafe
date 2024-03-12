<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<sp:url value="/" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/cssStyleIndex.css" />"
	rel="stylesheet">
	<title>Quản lý hàng hóa</title>
<script type="text/javascript">
	function deleteHangHoa(name, id) {
		let isDel = confirm(" Tên hàng hóa [" + name + "] có mã là " + id)
		if (isDel) {
			window.location = ("${rootpath}hang-hoa/delete/" + id);
		}
	}
</script>
</head>
<body>
	
		<h1 id="header">Giỏ hàng</h1>
		<hr>
		<nav id="navigation">
		<a href="${rootpath}" >Trang chủ</a></nav>
		<hr>
		<b id="message">${msg}</b>
<%-- 		<form id="search-form" action="${path}/search" method="get"> --%>
<!-- 			<input class="form-input" name="txtSearch" type="text" /> <input -->
<!-- 				class="form-submit" type="submit" value="Tìm kiếm" /> -->
<!-- 		</form> -->
	
		 <table id="data-table" class="custom-table" border="1">

			<tr>
				<th>Mã giỏ hàng</th>
				<th>Tên hàng hóa</th>
				<th>Số lượng</th>
				<th>Giá bán</th>
				<th>Ghi chú</th>
				<th>Mua hàng</th>
				<th>Xóa khỏi giỏ hàng</th>
			</tr>
			<c:forEach items="${lst}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.hanghoa.ten_hang_hoa}</td>
					<td>${item.so_luong}</td>
					<td><fmt:formatNumber value="${item.gia}" type="CURRENCY"
							currencyCode="VND" pattern="#,##0₫" /></td>
					<td>${item.hanghoa.ghi_chu}</td>
					<td align="center"><a
						href="${rootpath}hang-hoa/AddtoCart/${item.id}"><img
							style="width: 80px" alt="Add to Cart"
							src="${rootpath}/assets/img/purchase.png" /></a></td>
					<td align="center"><img alt="Delete"
						src="${rootpath}/assets/img/delete1.png"
						onclick="deleteHangHoa('${item.hanghoa.ten_hang_hoa}',${item.id})" /></td>
				</tr>
			</c:forEach>
		</table>

		
			<div>
				<!-- Calculate and display the total price -->
				<p>Total Price: ${totalPrice}</p>
			</div>
			<a href="${rootpath}hang-hoa/thanh-toan">Thanh Toán</a>
	</div>
</body>
</html>
