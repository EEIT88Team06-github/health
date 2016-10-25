<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- ****************************************************************** -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="subTitle" value="testindex" scope="session" />



<!-- ****************************************************************** -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>
</head>
<body>
	<a href="<c:url value='/recommands/validate.do' />">今日推薦</a><br/>
	<a href="<c:url value='/recommands/what.do?recommand=food' />" >食譜推薦</a><br/>
	<a href="<c:url value='/recommands/what.do?recommand=sport' />">運動推薦</a><br/>
	<a href="<c:url value='/calculaties/food/showfood.do' />">攝取熱量</a><br/>
	<a href="<c:url value='/calculaties/sport/showfood.do' />">消耗熱量</a><br/>
	<a href="<c:url value='/MembersOnly/healthrecord.jsp' />" >會員紀錄</a>
</body>
</html>