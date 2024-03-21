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
</head>
<body>
	<h3>Kết quả tìm kiếm</h3>
	<c:if test="${empty theRecruitments && empty theCompanies}">
		<p>Không có kết quả phù hợp</p>
	</c:if>
	<c:forEach var="tempRecruitment" items="${theRecruitments}">
		<c:url var="detailJob" value="/detailJobInSearch">
			<c:param name="recruitmentId" value="${tempRecruitment.id}" />
			<c:param name="companyId" value="${tempRecruitment.idCompany}" />
			<c:param name="userId" value="${userId}" />
		</c:url>
		<ul>
			<li><a href="${detailJob}">${tempRecruitment.title}</a></li>
		</ul>
	</c:forEach>
	<c:forEach var="tempCompany" items="${theCompanies}">
		<c:url var="detailCompany" value="/detailCompany">
			<c:param name="userId" value="${userId}" />
			<c:param name="companyId" value="${tempCompany.id}" />

		</c:url>
		<ul>
			<li><a href="${detailCompany}">${tempCompany.nameCompany}</a></li>
		</ul>
	</c:forEach>
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/homeUser?userId=${userId}">Trang
		chủ</a>
</body>
</html>