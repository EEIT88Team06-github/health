<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5;url=http://localhost:8080/Jealth/match/result.jsp" />
<title></title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="bootstrap/js/jquery-3.1.0.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>
<link href="css/load.css" rel="stylesheet" type="text/css" media="all" />


</head>
<body>
<jsp:include page="/global/default.jsp" />
       <div style="text-align:center;">
　<div style="margin:0 auto;border: 2px solid red; width:200px; background-color:red;color:black;">
   <h2> Let's go sport!!</h2>
  </div>
  <br>

<h1>搜尋中...</h1>
<br>
<br>
<br>
<br>
<div class="cssload-main">
	<div class="cssload-heart">
		<span class="cssload-heartL"></span>
		<span class="cssload-heartR"></span>
		<span class="cssload-square"></span>
	</div>
	<div class="cssload-shadow"></div>
</div>
<br>
<br>
<br>
<br>
<br>
親愛的${LoginOK.nickname}, 您好<P/>
<br>
您的性別為${LoginOK.gender}<P/> 
您的年齡為25<P/>
您的所在地位於${matchbean.city} ${matchbean.country}<P/>
<!--  您挑選的性別為 男性<p/>-->

  <c:choose>
   <c:when test="${empty matchbean}" >
       您未挑選性別
   </c:when>
   <c:otherwise >
       您挑選的性別為
       <c:forEach var="sex" items="${matchbean.ssex}"> 
          <c:out value="${sex}" />
       </c:forEach>
   </c:otherwise>
</c:choose>
<br>
<br>
<br>

</div>
<jsp:include page="/global/default_bottom.jsp" />	
</body>
</html>