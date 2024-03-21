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
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid px-md-4	">
			<div class="collapse navbar-collapse" id="ftco-nav">
				<a href="${pageContext.request.contextPath}/login" class="nav-link">Đăng
					nhập/Đăng ký</a>
			</div>
		</div>
	</nav>
	<!-- END nav -->
	<div class="hero-wrap img"
		style="background-image: url(user/assets/images/bg_1.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row d-md-flex no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-10 d-flex align-items-center ">
					<div class="text text-center pt-5 mt-md-5">
						<h1 class="mb-5">Cách dễ dàng nhất để có được công việc mới
							của bạn</h1>
						<div class="ftco-counter ftco-no-pt ftco-no-pb">
							<div class="row">
								<div
									class="col-md-4 d-flex justify-content-center counter-wrap ">
									<div class="block-18">
										<div class="text d-flex">
											<div class="icon mr-2">
												<span class="flaticon-visitor"></span>
											</div>
											<span>Ứng cử viên: <c:out value="${totalUser}"></c:out></span>
										</div>
									</div>
								</div>
								<div
									class="col-md-4 d-flex justify-content-center counter-wrap ">
									<div class="block-18 text-center">
										<div class="text d-flex">
											<div class="icon mr-2">
												<span class="flaticon-visitor"></span>
											</div>
											<div class="desc text-left">
												<span>Công ty: <c:out value="${totalCompany}"></c:out></span>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-4 d-flex justify-content-center counter-wrap">
									<div class="block-18 text-center">
										<div class="text d-flex">
											<div class="icon mr-2">
												<span class="flaticon-resume"></span>
											</div>
											<div class="desc text-left">
												<span>Tin tuyển dụng: <c:out
														value="${totalRecruitment}"></c:out></span>
											</div>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center mb-5">
				<div style="display: block"
					class="col-md-7 heading-section text-center">
					<h2 class="mb-0">Top 4 danh mục công việc tuyển dụng nhiều
						nhất</h2>
					<table>
						<thead>
							<tr>
								<c:forEach var="jobCategory" items="${theRecruitments}">
									<th>${jobCategory.jobCategory}</th>
								</c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
								<c:forEach var="jobCategory" items="${theRecruitments}">
									<td>${jobCategory.count}&nbsp;vị&nbsp;trí</td>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 pr-lg-5">
					<div class="row justify-content-center pb-3">
						<div class="col-md-12 heading-section ">
							<h2 class="mb-4">Top 3 việc làm nổi bật</h2>
							<h5>*** Vui lòng đăng nhập để ứng tuyển</h5>
						</div>

						<table>
							<tbody>
								<c:forEach var="tempTopRecruitment"
									items="${theTopRecruitments}">
									<tr>
										<td>${tempTopRecruitment.jobType}
											<h4>${tempTopRecruitment.title}</h4>
											${tempTopRecruitment.nameCompany} ||
											${tempTopRecruitment.address}
											<hr>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="col-lg-3 sidebar">
					<div class="row justify-content-center pb-3">
						<div class="col-md-12 heading-section ">
							<h2 class="mb-4">Top 3 công ty tuyển dụng nhiều nhất</h2>
							<c:forEach var="tempCompany" items="${theCompanies}">
								<table>
									<thead>
										<tr>
											<th>${tempCompany.nameCompany}</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>${tempCompany.count}&nbsp;vị&nbsp;trí&nbsp;ứng&nbsp;tuyển</td>
										</tr>
									</tbody>
								</table>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>