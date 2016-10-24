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
		<div>
			<table  id="TE1">
				<thead>
					
				</thead>
				<tbody>

						<tr>
							<th>
								<li>發佈日期 :</li>
								<li><p>今年第22號颱風「海馬」已於18日凌晨增強為強烈颱風，根據中央氣象局預測和觀察</p></li>
							</th>
							<th>
								<img src="" alt="" />
							</th>
						</tr>
						<tr>
							<th>
							<li>發佈日期 :</li>
							<li><p>海馬不會直接朝台灣撲來，但台灣颱風論壇提醒，「週四的轉折是關鍵」，</p></li>
							</th>
							<th>
							
								<img src="" alt="" />
							</th>
						</tr>
						
					</tbody>
				<tbody>
					<tr>
						<th><input type="text" style="width: 400px;height: 50px;"/></th>
						<th><input type="button" value="上傳圖片"/></th>
					</tr>
					<tr>
						<th>是否公開</th>
						<th><input type="checkbox" value=""/>是</th>
						<th><input type="checkbox" value=""/>否</th>
						<th><input type="button" value="發佈"/></th>
					</tr>
				</tbody>
		
			</table>	
		</div>
	</div>			
</div>
	
		
<jsp:include page="../global/default_bottom.jsp" />		

</body>
</html>