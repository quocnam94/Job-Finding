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
	<h3>Đăng ký</h3>
	<form:form action="saveUser" modelAttribute="user" method="POST">
		<form:hidden path="enabled" value="1" />
		<form:hidden path="role" value="USER" />
		<table>
			<tbody>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Họ và tên </label></td>
					<td><form:input path="fullName" /></td>
					<td><form:errors path="fullName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Mật khẩu</label></td>
					<td>
						<div>
							<form:input type="password" path="password" id="passwordField" />
							<button type="button"
								onclick="togglePasswordVisibility('passwordField')">Hiện</button>
						</div>
					</td>
					<td><form:errors path="password" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Nhập lại mật khẩu</label></td>
					<td>
						<div>
							<form:input type="password" path="matchingPassword"
								id="matchingPasswordField" />
							<button type="button"
								onclick="togglePasswordVisibility('matchingPasswordField')">Hiện</button>
						</div>
					</td>
					<td><form:errors path="matchingPassword" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Vai trò</label></td>
					<td><label> <form:select path="role">
								<form:option value="USER" label="Ứng viên" />
								<form:option value="COMPANY" label="Công ty" />
							</form:select>
					</label></td>
				</tr>
			</tbody>
		</table>
		<p>* Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ in hoa và in
			thường, ký tự đặc biệt và số</p>
		<table>
			<tr>
				<td><label></label></td>
				<td><input type="button" value="Close"
					style="position: absolute; left: 2%;"
					onclick="window.location.href='login'; return false;" /></td>
				<td><label></label></td>
				<td><input type="submit" value="Đăng ký"
					style="position: absolute; left: 10%;"></td>
			</tr>
		</table>
	</form:form>
	<br>
	<br>
	<c:if test="${not empty message}">
		<div style="color: red; font-weight: bold;">${message}</div>
	</c:if>
	<script>
		function togglePasswordVisibility(fieldId) {
			var passwordField = document.getElementById(fieldId);
			if (passwordField.type === "password") {
				passwordField.type = "text";
			} else {
				passwordField.type = "password";
			}
		}
	</script>
</body>
</html>