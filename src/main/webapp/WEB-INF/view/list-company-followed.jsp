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
	<h2>Danh sách công ty đã theo dõi</h2>
	<table>
		<tbody>
			<c:if test="${empty theCompanies}">
				<p>Bạn chưa theo dõi công ty nào</p>
			</c:if>
			<c:forEach var="tempCompanies" items="${theCompanies}">
				<tr>
					<td>${tempCompanies.nameCompany}
						<h4>${tempCompanies.email}</h4> ${tempCompanies.address} ||
						${tempCompanies.phoneNumber}
						<hr>
					</td>
					<td><c:set var="companyId" value="${tempCompanies.id}" /> <c:url
							var="detailCompany" value="/detailCompany"></c:url> <form:form
							action="${detailCompany}" method="GET">
							<button type="submit">Chi tiết</button>
							<input type="hidden" name="userId" value="${userId}" />
							<input type="hidden" name="companyId" value="${tempCompanies.id}" />
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