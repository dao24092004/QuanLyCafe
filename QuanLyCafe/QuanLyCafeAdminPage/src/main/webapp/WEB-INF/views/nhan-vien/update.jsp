<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/nhan-vien" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Cập nhật thông tin</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="page-container">
		<h1>Cập nhật thông tin</h1>
		<a class="link" href="${rootpath}">Trang chủ</a>|| <b
			style="color: red;">${msg}</b>
		<spf:form action="${path}/update" method="post" modelAttribute="nv">

			<table border="1">
				<tr>
					<th>Mã nhân viên</th>
					<td><spf:input path="id" type="text" readonly="true" /></td>
				</tr>
				<tr>
					<th>Tên Nhân viên</th>
					<td><spf:input path="ho_va_ten" type="text"
							placeholder="Nguyễn Văn A" /> <spf:errors cssClass="box-err"
							path="ho_va_ten" /></td>
				</tr>
				<tr>
					<th>Giới tính</th>
					<td><spf:radiobutton path="gioi_tinh" value="1" />Nam <spf:radiobutton
							path="gioi_tinh" value="0" />Nữ</td>
				</tr>
				<tr>
					<th>Ngày sinh</th>
					<td><spf:input path="ngay_sinh" type="date" /> <spf:errors
							cssClass="box-err" path="ngay_sinh" /></td>
				</tr>
				<tr>
					<th>Ngày vào làm</th>
					<td><spf:input path="ngay_vao_lam" type="date" /></td>
				</tr>
				<tr>
					<th>Số điện thoại</th>
					<td><spf:input path="di_dong" type="number"
							placeholder="03779999922" min="11" /> <spf:errors
							cssClass="box-err" path="di_dong" /></td>
				</tr>
				<tr>
					<th>Số điện thoại gia đình</th>
					<td><spf:input path="dt_gia_dinh" type="number"
							placeholder="03779999922" min="11" /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><spf:input path="email" type="text"
							placeholder="minhdao123@gmail.com" /> <spf:errors
							cssClass="box-err" path="email" /></td>
				</tr>
				<tr>
					<th>Địa chỉ</th>
					<td><spf:input path="dia_chi" type="text" /> <spf:errors
							cssClass="box-err" path="dia_chi" /></td>
				</tr>
				<tr>
					<th>ID Phân quyền</th>
					<td><spf:input path="phanquyen.id" type="number"
							placeholder="1" step="1" /> <spf:errors cssClass="box-err"
							path="phanquyen.id" /></td>
				</tr>
				<tr>
					<th>Lương cơ bản</th>
					<td><spf:input path="luong_co_ban" type="number" /></td>
				</tr>
				<tr>
					<th>UserName</th>
					<td><spf:input path="username" type="text" /> <spf:errors
							cssClass="box-err" path="username" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><spf:input path="passwords" type="text" /> <spf:errors
							cssClass="box-err" path="passwords" /></td>
				</tr>
				<tr>
					<th>Ghi chú</th>
					<td><spf:input path="ghi_chu" type="text" /></td>
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