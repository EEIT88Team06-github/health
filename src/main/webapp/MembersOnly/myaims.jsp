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
					
					<ul>
						<li>
							<a>目前體重狀態</a>
							<a>${BMI1}</a>
						</li>
						<li>
							<a>BMI</a>
							<a>${a}</a>
							<a>${b}</a>
							<a>${BmiText}</a>
						</li>
						<li>
							<a>基礎代謝率</a>
							<a>${BMR1}</a>
							<a>大卡</a>
						</li>
						<li>
							<a>您的健康體重範圍是  </a>
							<a>${gBMI1}</a><a>公斤</a>
							<a> ~ </a>
							<a>${gBMI2}</a><a>公斤</a>
						</li>
					</ul>	
				</div>
<!-- 				<ul> -->
<!-- 					<li> -->
<!-- 						<a>每月想瘦</a> -->
<!-- 						<input /><a>公斤</a> -->
<!-- 					</li> -->
<!-- 				<li><a>目標體重</a> <input type="text" name="newwb" /><a>公斤</a> <input -->
<!-- 					type="button" value="計算" /></li> -->
<!-- 					<li><a>想瘦日期預測</a></li> -->
<!-- 					<li><a>您將於</a> <a>達成目標!!</a></li> -->
<!-- 					<li><a>共需 </a> <a>天</a></li> -->
<!-- 					<li><a>每日建議熱量(kcal)</a></li> -->
<!-- 					<li><a>每日建議運動量(kcal) </a></li> -->
<!-- 				</ul> -->
		</div>
	</div>
<!--------------------------------------------------------------------------------------------->	
		
<jsp:include page="../global/default_bottom.jsp" />		

</body>
</html>