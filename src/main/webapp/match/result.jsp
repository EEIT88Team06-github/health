<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="10;url=http://localhost:8080/Jealth/match/map.jsp" />
<title></title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="bootstrap/js/jquery-3.1.0.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>


</head>
<body>
<jsp:include page="/global/default.jsp" />
		
<div style="text-align:center;">
　<div style="margin:0 auto;">
   <h1> 配對成功!!</h1>
  </div>
  <br>
<table align="center">
<tr>
    <td>
        <table border=1>
<tr>
    <td>
      <Form>
      <p/>暱稱:  <input  type="text"  name="nickName" value="${LoginOK.nickname}"readonly>
      <p/>性別:  <input  type="text"  name="gender"   value="${LoginOK.gender}"readonly>
      <p/>年齡:  <input  type="text"  name="age"      value="25"readonly>
      <p/>城市:  <input  type="text"  name="city"     value="${matchbean.city}"readonly>
      <p/>地區:  <input  type="text"  name="country"  value="${matchbean.country}"readonly>
      <P/>
      </Form>
  </td>
</tr>
        </table>	
    </td>
    <td>
        <table border=1>
<tr>
    <td>
      <Form>
      <p/>暱稱:  <input  type="text"  name="nickName" value="捷捷"readonly>
      <p/>性別:  <input  type="text"  name="gender"   value="男"readonly>
      <p/>年齡:  <input  type="text"  name="age"      value="26"readonly>
      <p/>城市:  <input  type="text"  name="city"     value="台北市"readonly>
      <p/>地區:  <input  type="text"  name="country"  value="大安區"readonly>
      <P/>
</Form>
    </td>
</tr>
        </table>	
    </td>
</tr>
</table>
</div>
   <jsp:include page="/global/default_bottom.jsp" />	
</body>
</html>