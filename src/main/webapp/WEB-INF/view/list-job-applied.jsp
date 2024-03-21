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
	<h2>Danh sách công việc đã ứng tuyển</h2>
	<table>
		<tbody>
			<c:if test="${empty theRecruitments}">
				<p>Bạn chưa ứng tuyển công việc nào</p>
			</c:if>
			<c:forEach var="tempRecruitments" items="${theRecruitments}">
				<tr>
					<td>${tempRecruitments.jobType}
						<h4>${tempRecruitments.title}</h4> ${tempRecruitments.nameCompany}
						|| ${tempRecruitments.address}
						<hr>
					</td>
					<td><c:url var="detailJobInSearch" value="/detailJobInSearch">
						</c:url> <form:form action="${detailJobInSearch}" method="GET">
							<button type="submit">Chi tiết</button>
							<input type="hidden" name="userId" value="${userId}" />
							<input type="hidden" name="companyId"
								value="${tempRecruitments.idCompany}" />
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