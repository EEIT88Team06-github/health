<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- ****************************************************************** -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="subTitle" value="test" scope="session" />



<!-- ****************************************************************** -->




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>
</head>
<body>
	<!-- 把這一段放到index的食物熱量連結裡 -->
	<a href="<c:url value='/calculaties/food/showfood.do' />">食物熱量</a>
	<a href="<c:url value='/calculaties/sport/showsport.do' />">運動消耗</a>
</body>
</html>