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
	<h3>Đăng bài</h3>
	<form:form action="saveJob" modelAttribute="recruitment" method="POST">
		<input name="userId" type="hidden" value="${user.id}" />
		<input name="nameCompany" type="hidden" value="${nameCompany}" />
		<input name="idCompany" type="hidden" value="${idCompany}" />

		<table>
			<tbody>
				<tr>
					<td><label>Tiêu đề</label></td>
					<td><form:input path="title" /></td>
					<td><form:errors path="title" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Mô tả công việc </label></td>
					<td><form:input path="description" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Kinh nghiệm </label></td>
					<td><form:input path="exp" /></td>
					<td><form:errors path="exp" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Số người cần tuyển</label></td>
					<td><form:input path="quantity" /></td>
					<td><form:errors path="quantity" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Địa chỉ</label></td>
					<td><form:input path="address" /></td>
					<td><form:errors path="address" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Hạn ứng tuyển</label></td>
					<td><form:input path="deadline" /></td>
					<td><form:errors path="deadline" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Mức lương </label></td>
					<td><form:input path="salary" /></td>
					<td><form:errors path="salary" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label>Loại công việc</label></td>
					<td><label> <form:select path="jobType">
								<form:option value="Fulltime" label="Fulltime" />
								<form:option value="Parttime" label="Part-time" />
								<form:option value="Freelancer" label="Freelancer" />
							</form:select>
					</label></td>
				</tr>
				<tr>
					<td><label>Danh mục công việc</label></td>
					<td><label> <form:select path="jobCategory">
								<form:option value="NodeJS" label="NodeJS" />
								<form:option value="Java" label="Java" />
								<form:option value="PHP" label="PHP" />
								<form:option value="ASP.NET" label="ASP.NET" />
								<form:option value="Other" label="Khác" />
							</form:select>
					</label></td>
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
					onclick="window.location.href='${pageContext.request.contextPath}/homeCompany?userId=${user.id}';" /></td>
				<td><label></label></td>
				<td><input type="submit" value="Đăng"
					style="position: absolute; left: 10%;"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>