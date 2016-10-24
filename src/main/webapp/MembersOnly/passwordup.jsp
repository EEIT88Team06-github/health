<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example</title>

<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="../bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="../bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="../bootstrap/js/jquery-3.1.0.js"></script>
<script src="../bootstrap/js/jquery-ui.min.js"></script>


</head>
<body>
		
<jsp:include page="../global/default.jsp" />
        
        
		<jsp:include page="/MembersOnly/signin.jsp" />
<!--------------------------------------------------------------------------------------------->

	<div>
		<div id="header-MbO">
			<jsp:include page="/MembersOnly/MbOTemplate.jsp" />
			
 	<form action="">
			<div>
				<ul id="lsnon">
					<li><a>修改密碼</a></li>
					<p/>
					<li><a>輸入舊密碼 : </a></li>
					<li><input type="password" id="oPd" value=""/></li>
					<a>${opw}</a>
					<p/>
					<li><a>輸入新密碼 : </a></li>
					<li><input type="password" id="nPd1" value=""/></li>
					<li><a>(密碼有區分大小寫，必須為8-10碼，至少兩碼英文，請注意填寫。)</a></li>
					<p/>
					<li><a>驗證新密碼 : </a></li>
					<li><input type="password" id="nPd2" value=""/></li>
					
<!-- 					np1=nP2=>newPassword -->
					
					<p/>
					<input type="button" value="確認修改"></input>
					<input type="button" value="取消修改"></input>
					</ul>
				</div>
			</form>
		</div>
	</div>
	<!--------------------------------------------------------------------------------------------->	
		
<jsp:include page="../global/default_bottom.jsp" />		

</body>
</html>