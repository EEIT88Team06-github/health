<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="bootstrap/js/jquery-3.1.0.js"></script>
<script src="bootstrap/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	//由<body>的onLoad事件處理函數觸發此函數
	function setFocusToUserId() {
		document.forms[0].userId.focus(); // 將游標放在userId欄位內
	}
</script>
</head>
<body>
		
<jsp:include page="/global/default.jsp" />
		
		<div id="wrapper">
			<div style="width: 100%;height: 50px" align="center">
				<span ><b> 會員登入</b></span>
				
			</div>
			<div id="page">
				<Form action="<c:url value='login.do' />" method="POST"
					name="loginForm">
					<div id='content' align="center">
						<Table width='500px' height="500px">
							<tr>
								<td width="180" align="center">會員帳號</td>
							</tr>
							<tr>
								<td width="180" align="center">
									<input type="text"
										name="userId" size="20" value="${sessionscope.user}">
										&nbsp;<small>
									<font color='red' size="-3">${ErrorMsgKey.AccountEmptyError}</font></small>
								</td>
							</tr>
							<tr>
								<td width="180" align="center">會員密碼</td>
							</tr>
							<tr>
								<td width="180" align="center"><input type="password"
									name="pswd" size="20" value="${sessionscope.password}">

									&nbsp;<small><font color='red' size="-3">${ErrorMsgKey.PasswordEmptyError}</font></small></td>

							</tr>
							<tr>
								<td width="180" height="30" align="center">驗證碼</td>
							</tr>
							<tr>
								<td align="center">
									<input type="text"
										name="checkCode" size="20" value="${sessionscope.checkCode}">
										&nbsp;<small>
									<font color='red' size="-3">${ErrorMsgKey.CheckCodeEmptyError}</font></small>
								</td>
							</tr>
							<tr>
								<td align="center">
									<img src="captcha"  height="50" width="150"> 
								</td>
							</tr>
							<tr>
								<td align="center"><input type="submit" value="確定">
								</td>
							</tr>
							<tr>
								<td align="center">
									<input type="checkbox" name="keepLogin" value="1"/>保持登入
									<a href="forgetPassword.jsp" style="color: blue">忘記密碼</a>
								</td>
							</tr>
							<tr height='10'>
								<td align="center" colspan='2'>&nbsp;</td>
							</tr>
						</Table>
					</div>
				</Form>
			</div>

		</div>
		
		
<jsp:include page="/global/default_bottom.jsp" />		

</body>
</html>