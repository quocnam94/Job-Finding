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
				<c:choose>
					<c:when test="${status}">
						<td><c:url var="unFollowJob" value="/unFollowJob"></c:url> <form:form
								action="${unFollowJob}" method="GET">
								<button type="submit">Bỏ theo dõi</button>
								<input type="hidden" name="userId" value="${userId}" />
								<input type="hidden" name="recruitmentId"
									value="${recruitment.id}" />
							</form:form></td>
					</c:when>
					<c:otherwise>
						<td><c:url var="followJob" value="/followJob"></c:url> <form:form
								action="${followJob}" method="GET">
								<button type="submit">Theo dõi</button>
								<input type="hidden" name="userId" value="${userId}" />
								<input type="hidden" name="recruitmentId"
									value="${recruitment.id}" />
							</form:form></td>
					</c:otherwise>
				</c:choose>
				<c:if test="${!statusApply}">
				<td><c:url var="applyJob" value="/applyJob">
					</c:url> <form:form action="${applyJob}" method="GET">
						<button type="submit">Apply Job</button>
						<input type="hidden" name="userId" value="${userId}" />
						<input type="hidden" name="recruitmentId"
							value="${recruitment.id}" />
					</form:form></td>
				</c:if>
				<c:if test="${not empty message}">
					<div style="color: red; font-weight: bold;">${message}</div>
				</c:if>
		</tbody>
	</table>
	<h2>
		Công việc trong công ty
		<c:out value="${nameCompany}"></c:out>
	</h2>
	<c:choose>
		<c:when test="${recruitments.size() >= 2}">
			<c:forEach var="tempRecruitment" items="${recruitments}">
				<c:url var="detailJob" value="/detailJobInSearch">
					<c:param name="recruitmentId" value="${tempRecruitment.id}" />
					<c:param name="companyId" value="${tempRecruitment.idCompany}" />
					<c:param name="userId" value="${userId}" />
				</c:url>
				<ul>
					<li><a href="${detailJob}">${tempRecruitment.title}</a></li>
				</ul>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>Không còn công việc nào</p>
		</c:otherwise>
	</c:choose>
	<a class="navbar-brand" href=""
		onclick="window.history.back(); return false;">Quay lại</a>
</body>
</html>