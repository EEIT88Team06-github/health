<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- ****************************************************************** -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="subTitle" value="今日推薦" scope="session" />

<!-- 判斷是否有登入 -->
<%-- <c:if test="${empty LoginOK}">  --%>
<%--    <c:set var="target" value="${pageContext.request.servletPath}" scope="session" /> --%>
<%--    <c:redirect url="/login.jsp" /> --%>
<%-- </c:if> --%>



<!-- ****************************************************************** -->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>

<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="../../bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="../../bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="../../bootstrap/js/jquery-3.1.0.js"></script>
<script src="../../bootstrap/js/jquery-ui.min.js"></script>



<style type="text/css">
	.recommand{
		width: 700px;
		height:500px ;
		border: 50px double #FF9797;
		margin: 20px;
		-moz-background-size: cover;
    	background-size: cover;
	}
	.subject{
		font-family: 微軟正黑體;
		font-size: 36px;
		color: gray;
		text-align: center;"
	}
	p{
		font-family: 微軟正黑體;
		font-size: 18px;
		color: gray;
		line-height: 26px;
	}
</style>
</head>
<body>
		
<jsp:include page= "../../global/default.jsp" />
		
		
		<div class="container" style="width: 1500px;-moz-background-size: cover;background-size: cover;">
			<div class="row" style="background:url(/health/images/bg01.jpg) repeat;">
				<form action="<c:url value='/recommands/what.do' />" method="post">
					<div class="col-md-6 col-xs-6">
						<input type="image" src="../img/recommandFood.jpg" alt="submit" name="recommand" value="food" class="recommand"/>
					</div>
					<div class="col-md-6 col-xs-6">
						<input type="image" src="../img/recommandSport.jpg" alt="submit" name="recommand" value="sport" class="recommand"/>
					</div>
				</form>
			</div>
			<div class="row">
				<div class="col-md-6 col-xs-6 subject">食譜推薦</div>
				<div class="col-md-6 col-xs-6 subject">運動推薦</div>
			</div>
		</div>

<jsp:include page= "../../global/default_bottom.jsp" />		

</body>
</html>