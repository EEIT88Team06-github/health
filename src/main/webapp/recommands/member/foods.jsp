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




<style type="text/css">
	.subject{
		font-family: 微軟正黑體;
		font-size: 60px;
		color:gray;
		text-align: center;
	}

	.info{
		font-family: 微軟正黑體;
		font-size: 36px;
		color:gray;
		text-align: center;
	}
	
	.cooking{
		display:block;
		font-family: 微軟正黑體;
		font-size: 20px;
		color:gray;
		text-align: justify;
		line-height: 36px;
		width: 90%;
	}

</style>


</head>
<body>
		
<jsp:include page="../../global/default.jsp" />
		

		<div class="container" style="height: 500px;width: 1500px;">
			
			<div class="row">
				<div class="col-md-3 col-xs-3">
					<img src="${pageContext.servletContext.contextPath }/recommands/img/cooker.png" 
						class="img-fluid" alt="Responsive image" width="100%" height="500px">
				</div>
				
				<div class="col-md-9 col-xs-9" style="background:url(/health/images/bg01.jpg) repeat;" >
					<div class="row" style="height:100px;text-align: center;letter-spacing: 50px;">
						<span class="subject">每日推薦</span>
					</div>
					
					<div class="col-md-6 col-xs-6" style="text-align: center;">
						<div class="row">
							<img src='${pageContext.servletContext.contextPath}/getImage?id=${recommand.id}&type=recommand' 
								 style="height: 350px;width: 450px"/>
						</div>	 
						<div class="row">
							<span class="info">熱量：</span><span class="info">${recommand.calories} </span><span class="info">  kcal</span>
						</div>	
					</div>
					
					<div class="col-md-6 col-xs-6" >
						<div class="row" style="text-align: center">
							<span class="info">${recommand.name} / </span><span class="info">${recommand.cookbookType} </span>
							
						</div>
						<div class="row">
							<br />
							<span class="info" style="font-size: 22px">烹調方式：</span>
							<br />
							<br />
							<span class="cooking">${recommand.cooking} </span>
						</div>
					</div>
				</div>
	
			</div>
		</div>
		
		
		
<jsp:include page="../../global/default_bottom.jsp" />		

</body>
</html>