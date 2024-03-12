<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<sp:url value="/admin/nha-cung-cap" var="path"></sp:url>
<sp:url value="/admin" var="rootpath"></sp:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/assets/css/styleInit-Update.css" />"
	rel="stylesheet">
<title>Thêm mới nhà cung cấp</title>
<style type="text/css">
.box-err {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div id="page-container">
		<h1>Thêm mới nhà cung cấp</h1>
		<a class="link" href="${rootpath}">Trang chủ</a>|| <a class="link"
			href="${path}">Nhà cung cấp</a>

		<spf:form action="${path}/insert" method="post" modelAttribute="ncc">
			<table border="1">
				<tr>
					<th>Tên nhà cung cấp</th>
					<td><spf:input path="ten_nhacc" type="text"
							placeholder="Cafe Trung Nguyên" /> <spf:errors
							cssClass="box-err" path="ten_nhacc" /></td>
				</tr>
				<tr>
					<th>Địa chỉ</th>
					<td><spf:input path="dia_chi" type="text" /> <spf:errors
							cssClass="box-err" path="dia_chi" /></td>
				</tr>
				<tr>
					<th>Số điện thoại 1</th>
					<td><spf:input path="sdt1" type="text" /> <spf:errors
							cssClass="box-err" path="sdt1" /></td>
				</tr>
				<tr>
					<th>Số điện thoại 2</th>
					<td><spf:input path="sdt2" type="text" /></td>
				</tr>
				<tr>
					<th>Fax</th>
					<td><spf:input path="fax" type="text" /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><spf:input path="email" type="text" /> <spf:errors
							cssClass="box-err" path="email" /></td>
				</tr>
				<tr>
					<th>Trang chủ nhà cung cấp</th>
					<td><spf:input path="website" type="text" /> <spf:errors
							cssClass="box-err" path="website" /></td>
				</tr>
				<tr>
					<th>Ngày tạo</th>
					<td><spf:input path="gay_tao" type="date" /></td>
				</tr>
				<tr>
					<th>Ngày cập nhật</th>
					<td><spf:input path="ngay_cap_nhat" type="date" /></td>
				</tr>
				<tr>
					<th>Mã số thuế</th>
					<td><spf:input path="tax_code" type="text" /></td>
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
					<td><input type="submit" value="Thêm mới" /></td>
				</tr>


			</table>
		</spf:form>
	</div>
</body>
</html>