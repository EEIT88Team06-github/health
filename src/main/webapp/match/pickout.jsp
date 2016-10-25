<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="bootstrap/js/jquery-3.1.0.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>


</head>
<script>
var form = document.getElementById("form_name");
//取得select的值
var ssex = form.sex.value;
</script>
<body>
<jsp:include page="/global/default.jsp" />
		
       <div style="text-align:center;">
　<div style="margin:0 auto;border: 2px solid red; width:200px; background-color:red;color:black;">
   <h2> Let's go sport!!</h2>
  </div>
  <br>
<%
java.util.Date d = new java.util.Date();
java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String date=sdf.format(d);
%>
<%=date %><br>
<br>
  <Form Action="../match/Search.do"method="POST">

      <p/>暱稱:  <input  type="text"  name="nickName" value="${LoginOK.nickname}"readonly>
      <p/>性別:  <input  type="text"  name="gender"   value="${LoginOK.gender}"readonly>
      <p/>年齡:  <input  type="text"  name="age"      value="25"readonly>
      <p/>城市:  <input  type="text"  name="city"     value="${LoginOK.city}"readonly>
      <p/>地區:  <input  type="text"  name="country"  value="${LoginOK.country}"readonly>
     
      <HR> 
		我要找:<P/>

	 	<select name="sex" >
　		<option value="男性">男性</option>
　		<option value="女性">女性</option>
		</select>
		<br><p/>
<!--
       <INPUT TYPE='checkbox' NAME='sex' VALUE='男性'> 男性 <BR>
	   <INPUT TYPE='checkbox' NAME='sex' VALUE='女性'> 女性 <BR><P/>
-->
		
      <P/>


<a href="http://localhost:8080/Jealth/match/Search.do"></a>
<input type='submit' value='GO'/><br>
<BR>
</Form>
</div>
		
<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>