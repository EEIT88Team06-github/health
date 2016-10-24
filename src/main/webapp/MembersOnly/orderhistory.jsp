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
<!--------------------------------------------------------------------------------------------->
	
	<jsp:include page="/MembersOnly/signin.jsp" />

<!--------------------------------------------------------------------------------------------->
	<div>
		<div id="header-MbO">
			<jsp:include page="/MembersOnly/MbOTemplate.jsp" />



		</div>
	</div>
	<!--------------------------------------------------------------------------------------------->	
		
<jsp:include page="../global/default_bottom.jsp" />		

</body>
</html>