<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css"
	rel="stylesheet">
<!-- jQuery -->
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/templatecss/health.css"
	rel="stylesheet">
<!-- template -->
<script
	src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
<title>Contacts</title>
</head>
<body>
	<jsp:include page="/global/default.jsp" />

	<div id="banner" class="container"
		style="height: 800px; width: 700px; vertical-align: middle">

		<c:forEach items="${contacts }" var="contacts">
			<form action="${pageContext.servletContext.contextPath}/shopping/Contacts">
						<input type="hidden" name="intend" value="change">
						<input type="hidden" name="id" value="${contacts.id }">
				<table cellspacing="10">
					<tr>
						<td><input class="btn btn-default" type="submit" name="action" value="寄送給..." ></td>
						<td><input type="text" name="name" value='<c:out value="${contacts.name }"></c:out>'></td>
						<td><input type="text" name="address" value='<c:out value="${contacts.contactAddress }"></c:out>'></td></span>
						<td><input type="text" name="phone" value='<c:out value="${contacts.phone }"></c:out>'></td>
						<td><input class="btn btn-default" type="submit" name="action" value="修改" ></td>
						<td><input class="btn btn-default" type="submit" name="action" value="刪除" ></td>
					</tr>
				</table>	
			</form>
		</c:forEach>
	</div>
	<div id="three-column" class="container"></div>

	<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>