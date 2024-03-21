<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<h3>Thông tin công ty</h3>
	<form:form action="saveCompany" modelAttribute="company" method="POST">
		<input name="userId" type="hidden" value="${userId}" />
		<table>
			<tbody>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Tên công ty </label></td>
					<td><form:input path="nameCompany" /></td>
					<td><form:errors path="nameCompany" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Địa chỉ</label></td>
					<td><form:input path="address" /></td>
					<td><form:errors path="address" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Số điện thoại</label></td>
					<td><form:input path="phoneNumber" /></td>
					<td><form:errors path="phoneNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Mô tả</label></td>
					<td><form:input path="description" /></td>
				</tr>
				<c:if test="${not empty message}">
					<div style="color: red; font-weight: bold;">${message}</div>
				</c:if>
			</tbody>
		</table>
		<table>
			<tr>
				<td><label></label></td>
				<td><input type="button" value="Đóng"
					style="position: absolute; left: 2%;"
					onclick="window.location.href='${pageContext.request.contextPath}/showProfileCompany?userId=${userId}';" /></td>
				<td><label></label></td>
				<td><input type="submit" value="Lưu"
					style="position: absolute; left: 10%;"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>