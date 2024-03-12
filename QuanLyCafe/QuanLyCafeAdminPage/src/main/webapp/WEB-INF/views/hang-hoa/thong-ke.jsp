<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<sp:url value="/admin" var="rootpath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thống kê hàng hóa</title>

</head>
<body>
	<div id="page-container">
		<h1>Thống kê hàng hóa theo ngày và tháng</h1>
		<hr>
		<a class="link" href="${rootpath}">Trang chủ</a> || <a class="link"
			href="${rootpath}/hang-hoa">Quản lý hàng hóa</a> || <a class="link"
			href="${rootpath}/nha-cung-cap">Quản lý nhà cung cấp</a> || <a
			class="link" href="${rootpath}/khach-hang">Quản lý khách hàng</a> ||
		<a>Xin chào, ${sessionScope.tennv}!</a><a class="link"
			href="${pageContext.request.contextPath}/admin/logout">(Đăng
			xuất)</a>

		<table border="1">
			<tr>
				<th>Tên hàng hóa</th>
				<th>Tổng số lượng bán</th>
				<th>Doanh thu</th>

			</tr>
			<c:forEach items="${lst}" var="item">
				<tr>
					<td>${item.ten_hang_hoa}</td>
					<td>${item.so_luong}</td>
					<td><fmt:formatNumber value="${item.doanh_thu}"
							type="CURRENCY" currencyCode="VND" pattern="#,##0₫" /></td>
				</tr>
			</c:forEach>
			<tr>
				<th>Tổng doanh thu</th>
				<td><fmt:formatNumber value="${tongtien}" type="CURRENCY"
						currencyCode="VND" pattern="#,##0₫" /></td>
			</tr>
		</table>

	</div>
</body>
</html>
