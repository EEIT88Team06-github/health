<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<meta name="description" content=""/>
<meta name="author" content=""/>
<title>ShowAllFood Manager Page</title>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css">  <!-- jQuery -->
    <script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
	<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>	
    
    <!-- Custom CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/sb-admin.css" rel="stylesheet"/>
    <!-- Morris Charts CSS -->
    <link href="${pageContext.servletContext.contextPath}/bootstrap/css/plugins/morris.css" rel="stylesheet"/>
    <!-- Custom Fonts -->
    
<c:if test="${empty LoginOK}">
	<c:redirect url="/login.jsp" />
</c:if>        
    
<style>
#page-wrapper{
	font-family:'consolas' , '微軟正黑體', sans-serif;
}
</style>
<script>
  var loadFile = function(event) {
    var output = document.getElementById('output');
    output.src = URL.createObjectURL(event.target.files[0]);
  };
</script>


</head>
<body>

<div id="wrapper">
<jsp:include page="/global/manager.jsp" />
<div id="page-wrapper" style="height:100vh"><!--網頁內容-->
	<div class="container-fluid">
<!-- **************************************  -->


	<div class="col-lg-12">
		<h1 class="page-header">
			食物新增 <small>New Food</small>		
		</h1>	
	</div>


<div class="col-lg-12">
<!-- form -->
    <div class="table-responsive">        
	<form action="<c:url value='/Manage/InsertFood.do' />" method="POST" enctype="multipart/form-data">
	<table>
		<tr>
			<td height="50px" width="80px">編號:</td>
			<td><input type="text" name="id" value="${param.id}">  <span>${error.id}</span> </td>
<%-- 			<td>${error.id}</td> --%>
		</tr>
		<tr>
			<td height="50px">名稱:</td>
			<td><input type="text" name="name" value="${param.name}"> <span>${error.name}</span> </td>
<%-- 			<td>${error.name}</td> --%>
		</tr>
		<tr>
			<td height="50px">種類:</td>
			<td><input type="text" name="foodType" value="${param.foodType}"> <span>${error.foodType}</span>  </td>
<%-- 			<td>${error.foodType}</td> --%>
		</tr>
		
		
		<tr>
		     <td height="50px">圖片:</td>
		     <td colspan="3">
		            <input type="file" name="pic" size="40" accept="image/*" onchange="loadFile(event)"/>
		     </td>

		     <td>${error.pic}</td>
		</tr>
		
		<tr>
			<td height="200px"></td>
			<td>
		     
		         <div style="height:150px; width:150px; border: 1px solid blue;">
        			<img id="output" style="width:150px; height:150px"/>
    			</div>    
			
			</td>
		</tr>
		
		
		<tr>
			<td height="50px">卡洛里:</td>
			<td><input type="text" name="calories" value="${param.calories}"> <span>${error.calories}</span> </td>
<%-- 			<td>${error.calories}</td> --%>
		</tr>
		<tr>
			<td height="50px">顯示狀態:</td>
			<td>
				<select name="FoodStatus">
					<option value="true">顯示</option>
					<option value="false">隱藏</option>
				</select>
			</td>
		</tr>
		<tr>
			<td height="80px" colspan="2">
				<input type="submit" name="foodtion" value="新增" class="btn btn-primary"></input>
				<input type="button" value="取消" class="btn btn-primary" onclick="window.location.href='<c:url value="/Manage/ShowAllFood.do"/> '">
				
			</td>
		</tr>
	</table>
	</form>	
    </div> 
<!-- form -->
</div>




      

<!-- **************************************  -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<jsp:include page="/global/manager_bottom.jsp" />
	

</body>
</html>