<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Work CV</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700&display=swap"
	rel="stylesheet">

<!-- CSS -->
<link rel="stylesheet" href="/assets/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="/assets/css/animate.css">
<link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="/assets/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/assets/css/magnific-popup.css">
<link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="/assets/css/owl.theme.default.min.css">
<link rel="stylesheet" href="/assets/css/aos.css">
<link rel="stylesheet" href="/assets/css/ionicons.min.css">
<link rel="stylesheet" href="/assets/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="/assets/css/jquery.timepicker.css">
<link rel="stylesheet" href="/assets/css/css/bootstrap-reboot.css">
<link rel="stylesheet" href="/assets/css/css/mixins/_text-hide.css">
<link rel="stylesheet" href="/assets/css/flaticon.css">
<link rel="stylesheet" href="/assets/css/icomoon.css">
<link rel="stylesheet" href="/assets/css/style.css">
<link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-grid.css">
<link rel="stylesheet" href="/assets/css/bootstrap/bootstrap-reboot.css">

</head>
<body>
	<h2>Chi tiết công việc</h2>
	<table>
		<thead>
			<tr>
				<th><label>Mô tả công việc</label></th>
				<th><label>Tóm tắt công việc</label></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${recruitment.description}"></c:out></td>
				<td>
					<ul>
						<li>Công ty: <c:out value="${recruitment.nameCompany}"></c:out></li>
						<li>Kiểu công việc: <c:out value="${recruitment.jobType}"></c:out></li>
						<li>Loai công việc: <c:out value="${recruitment.jobCategory}"></c:out></li>
						<li>Kinh nghiệm: <c:out value="${recruitment.exp}"></c:out></li>
						<li>Địa chỉ: <c:out value="${recruitment.address}"></c:out></li>
						<li>Lương: <c:out value="${recruitment.salary}"></c:out></li>
						<li>Số lượng: <c:out value="${recruitment.quantity}"></c:out></li>
						<li>Hạn nộp CV: <c:out value="${recruitment.deadline}"></c:out></li>						
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
	<form:form action="saveApplyJob" modelAttribute="applyJob"
		enctype="multipart/form-data" method="POST">
		<input type="hidden" name="userId" value="${user.id}" />
		<input type="hidden" name="recruitmentId" value="${recruitment.id}" />
		<h2>Apply: ${recruitment.title}</h2>
		<label for="submissionType">Chọn phương thức nộp CV:</label>
		<select id="submissionType" name="submissionType"
			onchange="toggleUpdateCV()">
			<option value="update">Dùng CV Đã Cập Nhật</option>
			<option value="new">Nộp CV Mới</option>
		</select>
		<div id="updateCVSection" style="display: none;">
			<label for="file">Chọn CV:</label> <input type="file" name="file"
				id="file"> <br>
			
		</div>
		<c:if test="${not empty message}">
				<div style="color: red; font-weight: bold;">${message}</div>
			</c:if>
		<br>
		<label>Giới thiệu</label>
		<form:input path="text" />
		<br>
		<br>
		<table>
			<tr>
				<td><label></label></td>
				<td><input type="button" value="Close"
					style="position: absolute; left: 2%;"
					onclick="window.location.href='${pageContext.request.contextPath}/homeUser?userId=${user.id}';" />
				<td><label></label></td>
				<td><input type="submit" value="Submit"
					style="position: absolute; left: 10%;"></td>
			</tr>
		</table>
	</form:form>

	<script>
		function toggleUpdateCV() {
			const submissionType = document.getElementById("submissionType").value;
			const updateCVSection = document.getElementById("updateCVSection");
			updateCVSection.style.display = submissionType === "new" ? "block"
					: "none";
		}
	</script>

</body>
</html>