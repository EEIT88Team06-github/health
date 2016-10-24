<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
<title>Finish</title>
</head>
<body >
<jsp:include page="/global/default.jsp" />
	
<div id="banner" class="container" style="height: 800px;width: 500px; vertical-align: middle">


	<div>
	<p align=center>非常感謝您的訂購，此次訂單編號為${requestScope.ordNum }</p>
	</div>
	<div>
	<p align=center>我們會盡速處理您的訂單，您可至會員專區查詢訂單處理流程</p>
	</div>
	<p></p>
	<p></p>
</div>
<div id="three-column" class="container"></div>

<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>