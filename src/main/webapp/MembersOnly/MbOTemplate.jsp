<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<link href="../css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/content.css" rel="stylesheet" type="text/css" />
<link href="../css/Header.css" rel="stylesheet" type="text/css"  />
</head>


<body>
	
					<ul id="navigation">
						<li id="01">
<!-- 					class="selected first" -->
<!-- 						<a href="http://localhost:8080/health/MembersOnly/account.jsp"> -->
							<a href="${pageContext.servletContext.contextPath}/MembersOnly/account.view">
						個人帳戶管理</a></li>
						
						<li id="02">
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/slimminglog.jsp">
						瘦身日誌</a></li>
						
						<li id="03">
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/healthrecord.jsp">
						健康紀錄</a></li>
						
						<li id="04">
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/myaims">
						我的目標</a></li>
						
						<li id="05">
<!-- 						<a href="http://localhost:8080/health/MembersOnly/collect.jsp"> -->
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/collect">
						文章收藏</a></li>
						
						<li id="06">
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/orderhistory.jsp">
<!-- 							<a href="http://localhost:8080/health/MembersOnly/orderhistory"> -->
						購買紀錄</a></li>
						
						<li id="07">
<!-- 						<a href="http://localhost:8080/health/MembersOnly/bonus.jsp"> -->
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/bonus">
						紅利點數查詢</a></li>
						
						<li id="08">
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/pdsubject">
<!-- 						<a href="http://localhost:8080/health/MembersOnly/publisheda.jsp"> -->
						發表的文章</a></li>
						
						<li id="09">
<!-- 						<a href="http://localhost:8080/health/MembersOnly/publishedv.jsp"> -->
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/pvmovie">
						發表的影片</a>
						</li>
 					</ul>
	
</body>
</html>