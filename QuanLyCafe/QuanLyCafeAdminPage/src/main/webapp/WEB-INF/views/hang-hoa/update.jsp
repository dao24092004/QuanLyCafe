<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/hang-hoa" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Cập nhật hàng hóa</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="page-container">
		<a class="link" href="${rootpath}">Trang chủ</a>|| <a class="link"
			href="${path}">Quản lý hàng hóa</a>
		<hr>
		<b>${msg}</b>
		<hr>
		<h1>Cập nhật hàng hóa</h1>

		<spf:form action="${path}/update" method="post" modelAttribute="hh">
			<table border="1">
				<tr>
					<th>Mã hàng hóa</th>
					<td><spf:input path="id" type="text" readonly="true" />
				</tr>
				<tr>
					<th>Mã vạch</th>
					<td><spf:input path="bar_code" type="text" /> <spf:errors
							cssClass="box-err" path="bar_code" /></td>
				</tr>
				<tr>
					<th>Tên Hàng hóa</th>
					<td><spf:input path="ten_hang_hoa" type="text" /> <spf:errors
							cssClass="box-err" path="ten_hang_hoa" /></td>
				</tr>
				<tr>
					<th>Chủng loại</th>
					<td><spf:select path="chungloai.id">
							<spf:options items="${lstcl}" itemLabel="ten" itemValue="id" />
						</spf:select></td>
				</tr>
				<tr>
					<th>Đơn vị</th>
					<td><spf:select path="donvi.id">
							<spf:options items="${lstdv}" itemLabel="ten_don_vi"
								itemValue="id" />
						</spf:select></td>
				</tr>
				<tr>
					<th>Nhà cung cấp</th>
					<td><spf:select path="nhacung.id">
							<spf:options items="${lstncc}" itemLabel="ten_nhacc"
								itemValue="id" />
						</spf:select></td>
				</tr>
				<tr>
					<th>Số lượng</th>
					<td><spf:input path="so_luong" type="number"  /></td>
				</tr>
				<tr>
					<th>Giá nhập</th>
					<td><spf:input path="gia_nhap" type="number" step="100" /></td>
				</tr>
				<tr>
					<th>Giá xuất</th>
					<td><spf:input path="gia_xuat" type="number" step="100" /></td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td><spf:input path="ngay_tao" type="date" readonly="true" />
					</td>
				</tr>
				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input path="ngay_cap_nhat" type="date" readonly="true" /></td>
				</tr>
				<tr>
					<th>Ghi chú</th>
					<td><spf:input path="ghi_chu" type="text" /></td>
				</tr>

				<tr>

					<th></th>
					<td><input type="submit" value="Cập nhật" /></td>
				</tr>


			</table>
		</spf:form>
	</div>
</body>
</html>