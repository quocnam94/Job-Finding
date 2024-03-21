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
<body>
	<h2>Chi tiết công ty</h2>
	<ul>
		<li>Công ty: <c:out value="${company.nameCompany}"></c:out></li>
		<li>Email: <c:out value="${company.email}"></c:out></li>
		<li>Địa chỉ: <c:out value="${company.address}"></c:out></li>
		<li>Số điện thoại: <c:out value="${company.phoneNumber}"></c:out></li>
		<li>Mô tả: <c:out value="${company.description}"></c:out></li>
	</ul>
	<c:choose>
		<c:when test="${status}">
			<td><c:url var="unFollowCompany" value="/unFollowCompany"></c:url>
				<form:form action="${unFollowCompany}" method="GET">
					<button type="submit">Bỏ theo dõi</button>
					<input type="hidden" name="userId" value="${userId}" />
					<input type="hidden" name="companyId" value="${company.id}" />
				</form:form></td>
		</c:when>
		<c:otherwise>
			<td><c:url var="followCompany" value="/followCompany"></c:url> <form:form
					action="${followCompany}" method="GET">
					<button type="submit">Theo dõi</button>
					<input type="hidden" name="userId" value="${userId}" />
					<input type="hidden" name="companyId" value="${company.id}" />
				</form:form></td>
		</c:otherwise>
	</c:choose>

	<h2>Công việc trong công ty</h2>
	<c:forEach var="tempRecruitment" items="${recruitments}">
		<c:url var="detailJob" value="/detailJobInSearch">
			<c:param name="recruitmentId" value="${tempRecruitment.id}" />
			<c:param name="userId" value="${userId}" />
			<c:param name="companyId" value="${tempRecruitment.idCompany}" />

		</c:url>
		<ul>
			<li><a href="${detailJob}">${tempRecruitment.title}</a></li>
		</ul>
	</c:forEach>

	<a class="navbar-brand" href=""
		onclick="window.history.back(); return false;">Quay lại</a>

</body>
</html>