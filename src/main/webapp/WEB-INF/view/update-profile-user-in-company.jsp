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
.nav-item.dropdown .dropdown-menu li {
	list-style-type: none;
}

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
	<h3>
		Xin chào
		<security:authentication property="principal.username" />
	</h3>
	<nav class="header_menu"
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container-fluid px-md-4	">
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="navbar-brand"
						href="${pageContext.request.contextPath}/homeCompany?userId=${user.id}">Trang
							chủ</a></li>
					<li class="nav-item"><a
						href="${pageContext.request.contextPath}/listCandidate?userId=${user.id}"
						class="nav-link">Ứng cử viên</a></li>
					<li class="nav-item dropdown"><a href="#"
						class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${company.nameCompany}</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><c:url var="updateProfileUserInCompany"
									value="/updateProfileUserInCompany">
								</c:url> <form:form action="${updateProfileUserInCompany}" method="GET">
									<button type="submit">Hồ sơ cá nhân</button>
									<input type="hidden" name="userId" value="${user.id}" />
								</form:form></li>
							<li><c:url var="showProfileCompany"
									value="/showProfileCompany">
								</c:url> <form:form action="${showProfileCompany}" method="GET">
									<button type="submit">Hồ sơ công ty</button>
									<input type="hidden" name="userId" value="${user.id}" />
								</form:form></li>
							<li><c:url var="listJob" value="/listJob">
								</c:url> <form:form action="${listJob}" method="GET">
									<button type="submit">Danh sách bài đăng</button>
									<input type="hidden" name="userId" value="${user.id}" />
								</form:form></li>
							<li><form:form action="${pageContext.request.contextPath}/"
									method="GET">
									<input type="submit" value="Đăng xuất" />
								</form:form></li>
						</ul></li>
					<li><c:url var="createJob" value="/createJob">
						</c:url> <form:form action="${createJob}" method="GET">
							<a
								href="${pageContext.request.contextPath}/createJob?userId=${user.id}"
								class="link-button">Đăng tuyển</a>
							<input type="hidden" name="userId" value="${user.id}" />
						</form:form></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Modal -->
	<section class="site-section" style="margin-top: 10px">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 mb-5">
					<h2 class="mb-4">Thông tin cá nhân</h2>
					<form:form action="saveUserInCompany" modelAttribute="user"
						method="POST">
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
									<c:if test="${not empty message}">
										<div style="color: red; font-weight: bold;">${message}</div>
									</c:if>
								</div>
							</div>
						</div>
						<table>
							<tr>
								<td><label></label></td>
								<td><input type="button" value="Đóng"
									style="position: absolute; left: 2%;"
									onclick="window.location.href='${pageContext.request.contextPath}/homeCompany?userId=${user.id}';" />
								<td><label></label></td>
								<td><input type="submit" value="Lưu"
									style="position: absolute; left: 10%;"></td>
							</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</section>
	<script>
		document.querySelector('.dropdown')
				.addEventListener(
						'click',
						function() {
							var dropdownMenu = document
									.querySelector('.dropdown-menu');
							if (dropdownMenu.style.display === "none"
									|| dropdownMenu.style.display === "") {
								dropdownMenu.style.display = "block";
							} else {
								dropdownMenu.style.display = "none";
							}
						});
	</script>
</body>
</html>