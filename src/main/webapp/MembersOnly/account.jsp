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
<link href="../css/MBOC.css" rel="stylesheet"> 


</head>
<body>
		
<jsp:include page="../global/default.jsp" />


	<jsp:include page="/MembersOnly/signin.jsp" />

	<!--------------------------------------------------------------------------------------------->
	
	<div>
		<div id="header-MbO">
			<jsp:include page="/MembersOnly/MbOTemplate.jsp" />
		</div>

			<div class="atulli">
				<div id="acc">
					<ul id="accli">
					
						<form action="<c:url value='/MembersOnly/account.do'/>" method="post">
							<tr>
								<th><li><a>帳號 : </a></th>
								<th><a name="account" >${accountText}</a>
									</li></th>
								<td></td>
							</tr>

							<li><input type="button" value="修改密碼"
								onclick="location.href='http://localhost:8080/health/MembersOnly/pwp'" /></li>

							<li><a>會員名稱</a></li>

							<label class="control-label" for="input01">姓 : </label>
							<div class="controls">
								<input type="text" placeholder="請輸入中文" class="input-xlarge"
									name="lastname" value="${lastnameT}">
									<p class="help-block"></p>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">名 : </label>
								<div class="controls">
									<input type="text" placeholder="請輸入中文" class="input-xlarge"
										value="${firstnameT}" name="firstname">
										<p class="help-block" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="input01">暱稱 : </label>
								<div class="controls">
									<input type="text" placeholder="" class="input-xlarge"
										name="nickname" value="${nicknameT}" />
									<p class="help-block"></p>
								</div>
							</div>
							<div class="control-group">
								<tr>
									<th><a>生日 : </a></th>
									<th><a name="birth">${birthT}</a></th>
								</tr>
							</div>
							<div class="control-group">
								<label class="control-label" for="input01">電話(手機) : </label>
								<div class="controls">
									<input type="text" placeholder="" class="input-xlarge"
										name="phone" value="${phoneT}">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label">是否參加配對</label>
								<div class="controls">
									<label class="radio"> <input type="radio" value="1"
										name="prodaction" checked="checked" id="Pr1" name="Pair">
											是 </label> 
									<label class="radio"> <input type="radio"
										value="0" name="prodaction" id="Pr0" name="Pair"> 否 </label>
								</div>
							</div>
			
						
					<tr>
						<a>居住地區 : </a>
					<li></li>
					<tr>
						<a>縣市 : </a>
						<input href="#" onclick="" type="text" value="${cityT}"/>
					</tr><li></li>
					
					<tr><a>鄉鎮 : </a>
							<input type="text" value="${countryT}"/>
					</tr><li></li>
							
					<tr><a>地址 : </a>
							<input type="text" value="${addrT}"/>
					</tr><li></li>
					
					<tr>
						<a>E-mail : </a>
						<input name="email" value="${emailT}"/>
					</tr>
					
					<li>
						<input name="prodaction" type="submit" value="Update"/>
						<input name="prodaction" type="reset"  value="取消修改"/> 
					</form>
					</div>
					
					 </li>
					 </ul>
				</div>
<!-- 				<div class="ModifyAvatar"> -->
<!-- 					<label class="control-label">修改照片</label> -->
<!-- 				<div class="controls"> -->
<!-- 					<Form Action="mygetfile" Method="POST"> -->
<!-- 						<IMG width='320' height='240' -->
<!-- 							SRC=""/> -->
<%-- "${pageContext.servletContext.contextPath}/images/images (2).jpg" --%>
<!-- 							<input class="input-file" id="fileInput" type="file"> -->
<!-- 					</Form>	 -->
<!-- 				</div> -->
<!-- 			</div> -->
		
<jsp:include page="../global/default_bottom.jsp" />		

</body>
</html>