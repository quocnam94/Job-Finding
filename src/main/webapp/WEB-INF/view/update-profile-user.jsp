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

<style>
.error {
	color: red
}
</style>
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
	<!-- Modal -->
	<section class="site-section" style="margin-top: 10px">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-5">
					<h1>Hồ sơ</h1>
					<h4>Cập nhật CV</h4>
					<form:form method="POST" action="upload"
						enctype="multipart/form-data">
						<label for="file">Chọn CV:</label>
						<input type="file" name="file" id="file">
						<input type="hidden" name="userId" value="${user.id}">
						<br>
						<c:if test="${not empty message}">
							<div style="color: red; font-weight: bold;">${message}</div>
						</c:if>
						<br>
						<button type="submit">Upload</button>
					</form:form>


					<h4 class="mb-4">Cập nhật thông tin</h4>
					<form:form action="saveUpdateUser" modelAttribute="user"
						method="GET">
						<form:hidden path="enabled" value="1" />
						<form:hidden path="password" value="${password}" />
						<form:hidden path="role" value="${role}" />
						<form:hidden path="id" value="${id}" />
						<div class="row mb-5">
							<div class="col-lg-12">
								<div class="p-4 p-md-5 border rounded">
									<div class="form-group">
										<label for="email">Email</label>
										<form:input type="email" class="form-control" id="email"
											path="userName" />
										<form:errors path="userName" cssClass="error" />
									</div>
									<div class="form-group">
										<label for="job-title">Họ và tên</label>
										<form:input type="text" class="form-control" id="job-title"
											path="fullName" />
									</div>
									<div class="form-group">
										<label for="job-location">Địa chỉ</label>
										<form:input type="text" name="address" class="form-control"
											id="job-location" path="address" />
									</div>
									<div class="form-group">
										<label for="job-location">Số điện thoại</label>
										<form:input type="text" name="phoneNumber"
											class="form-control" id="job-location" path="phoneNumber" />
										<form:errors path="phoneNumber" cssClass="error" />
									</div>
									<div class="form-group">
										<label for="job-location">Mô tả bản thân</label>
										<form:input type="text" name="description"
											class="form-control" id="editor" path="description" />
									</div>
									<c:if test="${not empty messageUpdate}">
										<div style="color: red; font-weight: bold;">${messageUpdate}</div>
									</c:if>
								</div>
							</div>
						</div>
						<table>
							<tr>
								<td><label></label></td>
								<td><input type="button" value="Đóng"
									style="position: absolute; left: 2%;"
									onclick="window.location.href='${pageContext.request.contextPath}/homeUser?userId=${user.id}';" />
								<td><label></label></td>
								<td><input type="submit" value="Lưu thông tin"
									style="position: absolute; left: 10%;"></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>