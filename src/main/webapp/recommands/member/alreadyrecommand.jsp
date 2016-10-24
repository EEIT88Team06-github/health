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
<%--    <c:redirect url="/login.jsp" />  --%>
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


</head>
<body>
		
<jsp:include page="../../global/default.jsp" />
		

		<div class="container" style="height: 500px;width: 75%;">
			<div class="col-md-4 col-xs-4">
				<img src="${pageContext.servletContext.contextPath }/recommands/img/already.jpg" 
						class="img-fluid" alt="Responsive image" width="100%" height="500px">
			</div>
			<div class="col-md-8 col-xs-8" style="background:url(/health/images/bg01.jpg) repeat;height: 100%;border-radius:100px;">
				<h1 style="font-size:60px;text-align: center;font-family: 微軟正黑體;padding: 20% 0 0 0;color:gray;">今天已經推薦過了喔!!</h1>
			</div>
			
		</div>
		
		
		
<jsp:include page="../../global/default_bottom.jsp" />		

</body>
</html>