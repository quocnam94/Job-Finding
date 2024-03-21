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
</head>
<body>
<body>
	<h2>Danh sách công việc đã theo dõi</h2>
	<table>
		<tbody>
			<c:if test="${empty theRecruitments}">
				<p>Bạn chưa theo dõi công việc nào</p>
			</c:if>
			<c:forEach var="tempRecruitments" items="${theRecruitments}">
				<tr>
					<td>${tempRecruitments.jobType}
						<h4>${tempRecruitments.title}</h4> ${tempRecruitments.nameCompany}
						|| ${tempRecruitments.address}
						<hr>
					</td>
					<c:set var="recruitmentId" value="${tempRecruitments.id}" />
					<c:choose>
						<c:when test="${statusMapJob[recruitmentId]}">
							<td><c:url var="unFollowJob" value="/unFollowJob"></c:url> <form:form
									action="${unFollowJob}" method="GET">
									<button type="submit">Bỏ theo dõi</button>
									<input type="hidden" name="userId" value="${userId}" />
									<input type="hidden" name="recruitmentId"
										value="${tempRecruitments.id}" />
								</form:form></td>
						</c:when>
						<c:otherwise>
							<td><c:url var="followJob" value="/followJob"></c:url> <form:form
									action="${followJob}" method="GET">
									<button type="submit">Theo dõi</button>
									<input type="hidden" name="userId" value="${userId}" />
									<input type="hidden" name="recruitmentId"
										value="${tempRecruitments.id}" />
								</form:form></td>
						</c:otherwise>
					</c:choose>
					<td><c:url var="applyJob" value="/applyJob">
						</c:url> <form:form action="${applyJob}" method="GET">
							<button type="submit">Ứng tuyển</button>
							<input type="hidden" name="userId" value="${userId}" />
							<input type="hidden" name="recruitmentId"
								value="${tempRecruitments.id}" />
						</form:form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="navbar-brand"
		href="${pageContext.request.contextPath}/homeUser?userId=${userId}">Trang
		chủ</a>
</body>
</html>