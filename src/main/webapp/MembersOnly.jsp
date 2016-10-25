<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="/bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="/bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="/bootstrap/js/jquery-3.1.0.js"></script>
<script src="/bootstrap/js/jquery-ui.min.js"></script>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700|Archivo+Narrow:400,700" rel="stylesheet" type="text/css">
<!-- <link href="css/MembersOnly.css" /> -->

"src/main/webapp/"
<script type="text/javascript" src="js/jquery.layerModel.js"></script>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="${pageContext.servletContext.contextPath}/css/content.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.servletContext.contextPath}/css/MBOC.css" rel="stylesheet" type="text/css" />


<body>
		<jsp:include page="/global/default.jsp" />
		


<!--------------------------------------------------------------------------------------------->

<div class="content">
<div>
		<div>
			<ul>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/account.view">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict01.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/account.view">
					個人帳戶管理</a>
				</li>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/slimminglog.jsp">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict02.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/slimminglog.jsp">
					瘦身日誌</a>
				</li>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/healthrecord.jsp">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict03.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/healthrecord.jsp">
					健康紀錄</a>
				</li>
				
			</ul>
				<ul>
					<li>
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/myaims.jsp"><img
						src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict04.jpg" alt=""></a> <a
						href="${pageContext.servletContext.contextPath}/MembersOnly/myaims.jsp">我的目標</a>
					</li>
					<li>
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/collect"><img
						src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict05.jpg" alt=""></a> <a
						href="${pageContext.servletContext.contextPath}/MembersOnly/collect">文章收藏</a>
					</li>
					<li>
						<a href="${pageContext.servletContext.contextPath}/MembersOnly/orderhistory.jsp"><img
						src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict02.jpg" alt=""></a> <a
						href="${pageContext.servletContext.contextPath}/MembersOnly/orderhistory.jsp">購買紀錄</a>
					</li>
				</ul>
			<ul>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/bonus">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict01.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/bonus">
					紅利點數查詢</a>
				</li>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/pdsubject">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict03.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/pdsubject">
					發表的文章</a>
				</li>
				<li>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/pvmovie">
					<img src="${pageContext.servletContext.contextPath}/MbOnlyimages/pict04.jpg" alt=""></a>
					<a href="${pageContext.servletContext.contextPath}/MembersOnly/pvmovie">
					發表的影片</a>
				</li>
			</ul>
		</div>
	</div>
</div>

<!--------------------------------------------------------------------------------------------->	
		
		<jsp:include page="/global/default_bottom.jsp" />
		
</body>
</html>