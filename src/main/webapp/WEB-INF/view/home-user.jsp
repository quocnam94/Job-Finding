<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h3>
		Xin chào
		<security:authentication property="principal.username" />
	</h3>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid px-md-4	">
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li><c:url var="homeUser" value="/homeUser">
						</c:url> <form:form action="${homeUser}" method="GET">
							<button type="submit">Trang chủ</button>
							<input type="hidden" name="userId" value="${userId}" />
						</form:form></li>
					<li><c:url var="listJobFollowed" value="/listJobFollowed">
						</c:url> <form:form action="${listJobFollowed}" method="GET">
							<button type="submit">Công việc đã theo dõi</button>
							<input type="hidden" name="userId" value="${userId}" />
						</form:form></li>
					<li><c:url var="listJobApplied" value="/listJobApplied">
						</c:url> <form:form action="${listJobApplied}" method="GET">
							<button type="submit">Công việc đã ứng tuyển</button>
							<input type="hidden" name="userId" value="${userId}" />
						</form:form></li>
					<li><c:url var="listCompanyFollowed"
							value="/listCompanyFollowed">
						</c:url> <form:form action="${listCompanyFollowed}" method="GET">
							<button type="submit">Công ty đã theo dõi</button>
							<input type="hidden" name="userId" value="${userId}" />
						</form:form></li>
					<li><c:url var="updateProfileUser" value="/updateProfileUser">
						</c:url> <form:form action="${updateProfileUser}" method="GET">
							<button type="submit">Cập nhật thông tin</button>
							<input type="hidden" name="userId" value="${userId}" />
						</form:form></li>
					<li class="nav-item cta cta-colored"><form:form
							action="${pageContext.request.contextPath}/" method="GET">
							<input type="submit" value="Đăng xuất" />
						</form:form></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="hero-wrap img"
		style="background-image: url(user/assets/images/bg_1.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row d-md-flex no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-10 d-flex align-items-center ">
					<div class="text text-center pt-5 mt-md-5">
						<p class="mb-4">Tìm việc làm, Cơ hội việc làm và Nghề nghiệp</p>
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
						<br>
						<div class="ftco-search my-md-5">
							<div class="row">
								<div class="col-md-12 tab-wrap">
									<div class="tab-content p-4" id="v-pills-tabContent">
										<div class="tab-pane fade show active" id="v-pills-1"
											role="tabpanel" aria-labelledby="v-pills-nextgen-tab">
											<form:form action="search" method="GET"
												onsubmit="return validateForm()">
												<input type="text" name="theSearch" id="theSearch"
													placeholder="Tìm kiếm công việc, công ty hoặc địa điểm" />
												<input type="hidden" name="userId" value="${userId}" />
												<input type="submit" value="Tìm kiếm" />
											</form:form>
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
										<c:set var="recruitmentId" value="${tempTopRecruitment.id}" />
										<c:choose>
											<c:when test="${statusMapJob[recruitmentId]}">
												<td><c:url var="unFollowJob" value="/unFollowJob"></c:url>
													<form:form action="${unFollowJob}" method="GET">
														<button type="submit">Bỏ theo dõi</button>
														<input type="hidden" name="userId" value="${userId}" />
														<input type="hidden" name="recruitmentId"
															value="${tempTopRecruitment.id}" />
													</form:form></td>
											</c:when>
											<c:otherwise>
												<td><c:url var="followJob" value="/followJob"></c:url>
													<form:form action="${followJob}" method="GET">
														<button type="submit">Theo dõi</button>
														<input type="hidden" name="userId" value="${userId}" />
														<input type="hidden" name="recruitmentId"
															value="${tempTopRecruitment.id}" />
													</form:form></td>
											</c:otherwise>
										</c:choose>
										<td><c:url var="applyJob" value="/applyJob">
											</c:url> <form:form action="${applyJob}" method="GET">
												<button type="submit">Ứng tuyển</button>
												<input type="hidden" name="userId" value="${userId}" />
												<input type="hidden" name="recruitmentId"
													value="${tempTopRecruitment.id}" />
											</form:form></td>
									</tr>
								</c:forEach>
								<c:if test="${not empty message}">
									<div style="color: red; font-weight: bold;">${message}</div>
								</c:if>
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
										<c:set var="companyId" value="${tempCompany.id}" />
										<c:choose>
											<c:when test="${statusMapCompany[companyId]}">
												<td><c:url var="unFollowCompany"
														value="/unFollowCompany"></c:url> <form:form
														action="${unFollowCompany}" method="GET">
														<button type="submit">Bỏ theo dõi</button>
														<input type="hidden" name="userId" value="${userId}" />
														<input type="hidden" name="companyId"
															value="${tempCompany.id}" />
													</form:form></td>
											</c:when>
											<c:otherwise>
												<td><c:url var="followCompany" value="/followCompany"></c:url>
													<form:form action="${followCompany}" method="GET">
														<button type="submit">Theo dõi</button>
														<input type="hidden" name="userId" value="${userId}" />
														<input type="hidden" name="companyId"
															value="${tempCompany.id}" />
													</form:form></td>
											</c:otherwise>
										</c:choose>
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
	<script>
		function validateForm() {
			var x = document.getElementById("theSearch").value;
			if (x == null || x == "") {
				alert("Nhập công việc, tên công ty hoặc địa điểm để tìm kiếm");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>