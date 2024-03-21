<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Work CV</title>
<style>
.failed {
	color: red;
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
	<nav class="header_menu"
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container-fluid px-md-4	">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Work
				CV</a>
		</div>
	</nav>
	<!-- HOME -->
	<section class="site-section">
		<div class="container">
			<div class="row">

				<div class="col-lg-6">
					<h2 class="mb-4">Đăng nhập</h2>
					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser"
						method="post" class="p-4 border rounded">
						<c:if test="${param.error != null }">
							<i class="failed">Sai tên đăng nhập hoặc mật khẩu</i>
						</c:if>
						<div class="row form-group">
							<div class="col-md-12 mb-3 mb-md-0">
								<label class="text-black" for="fname">Email</label> <input
									type="text" id="username" name="username" class="form-control"
									placeholder="Email" required>
							</div>
						</div>
						<br>
						<div class="row form-group mb-4">
							<div class="col-md-12 mb-3 mb-md-0">
								<label class="text-black" for="fname">Mật khẩu</label> <input
									type="password" id="passwordField" name="password"
									class="form-control" placeholder="Mật khẩu" required>
								<button type="button"
									onclick="togglePasswordVisibility('passwordField')">Hiện</button>
							</div>
						</div>
						<br>
						<div class="row form-group">
							<div class="col-md-12">
								<input type="submit" value="Đăng nhập"
									class="btn px-4 btn-primary text-white">
							</div>
						</div>
						<p>
							Bạn chưa có tài khoản? Bấm vào <a href="register">đây</a> để đăng
							ký
						</p>
					</form:form>
				</div>
			</div>
		</div>
	</section>
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