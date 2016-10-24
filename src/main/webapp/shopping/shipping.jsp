<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/global/default.jsp" />
	
	<div id="banner" class="container" style="height: 800px;width: 700px; vertical-align: middle">
		<div>
			<h1>購買人:</h1>
			<form>
				姓名:<input name="buyerName" type="text" value="${LoginOK.lastname }${LoginOK.firstname}"> 手機:<input name="buyerName" type="text" value="${LoginOK.phone}"> 
				<br>
				住址:<input name="buyerAddr" type="text" value="${LoginOK.city }${LoginOK.country }${LoginOK.addr }"> 郵遞區號:<input name="buyerPost" type="text">
			</form>
		</div>
		<br>
		<hr>
		<br>
		<div>
			<h1>收貨人:</h1>
			<form>
				<a href="#">同購買人資料</a>
				<c:if test="${ empty sessionScope.contact }" >
				<br>姓名:<input type="text" value="${LoginOK.lastname }${LoginOK.firstname}"> 手機:<input type="text" value="${LoginOK.phone }"> 
				<br>
				住址:<input type="text" value="${LoginOK.city }${LoginOK.country}${LoginOK.addr}"> 郵遞區號:<input type="text">
				<br>
				<a href="<c:url value='/shopping/Contacts?intend=selectAll'/>">通訊錄請按此</a>
				</c:if>
				<c:if test="${ ! empty sessionScope.contact }" >
				<br>姓名:<input type="text" value="${contact.name }"> 手機:<input type="text" value="${contact.phone }"> 
				<br>
				住址:<input type="text" value="${contact.contactAddress }"> 郵遞區號:<input type="text">
				<br>
				<a href="<c:url value='/shopping/Contacts?intend=selectAll'/>">通訊錄請按此</a>
				</c:if>
			</form>
		</div>
		<a href="<c:url value='/shopping/Order?intend=finish'/>">確定</a>
	</div>

	<div id="three-column" class="container"></div>
	<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>