<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/khach-hang" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thêm mới khách hàng</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="page-container">
		<h1>Thêm mới khách hàng</h1>
		<a class="link" href="${rootpath}">Trang chủ</a>|| <a class="link" href="${path}">Quản lý
			khách hàng</a>

		<spf:form action="${path}/update" method="post" modelAttribute="kh">
			<table border="1">
				<tr>
					<th>Mã khách hàng</th>
					<td><spf:input path="id" type="text" readonly="true" /></td>
				</tr>
				<tr>
					<th>Họ</th>
					<td><spf:input path="ho" type="text" /> <spf:errors
							cssClass="box-err" path="ho" /></td>
				</tr>
				<tr>
					<th>Tên khách hàng</th>
					<td><spf:input path="ten" type="text" placeholder=" Anh" /> <spf:errors
							cssClass="box-err" path="ten" /></td>
				</tr>
				<tr>
					<th>Giới tính</th>
					<td><spf:radiobutton path="gioi_tinh" value="1" />Nam <spf:radiobutton
							path="gioi_tinh" value="0" />Nữ</td>

				</tr>
				<tr>
					<th>Ngày sinh</th>
					<td><spf:input path="ngay_sinh" type="date" />
				</tr>
				<tr>
					<th>Số điện thoại</th>
					<td><spf:input path="dien_thoai" type="text" /> <spf:errors
							cssClass="box-err" path="dien_thoai" /></td>
				</tr>
				<tr>
					<th>Địa chỉ</th>
					<td><spf:input path="dia_chi" type="text" /> <spf:errors
							cssClass="box-err" path="dia_chi" /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><spf:input path="email" type="text" /> <spf:errors
							cssClass="box-err" path="email" /></td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td><spf:input path="ngay_tao" type="date" readonly="true" />
					</td>
				</tr>
				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input path="ngay_cap_nhat" type="date" /></td>
				</tr>
				<tr>
					<th>Trạng thái</th>
					<td><spf:checkbox path="trang_thai" value="1" /></td>
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