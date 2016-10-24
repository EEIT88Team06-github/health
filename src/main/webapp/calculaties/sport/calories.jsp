<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- ****************************************************************** -->


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="subTitle" value="食物熱量" scope="session" />

<!-- 判斷是否有登入 -->
<%-- <c:if test="${empty LoginOK}">  --%>
<%--    <c:set var="target" value="${pageContext.request.servletPath}" scope="session" /> --%>
<%--    <c:redirect url="/login.jsp" /> --%>
<%-- </c:if> --%>



<!-- ****************************************************************** -->




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>

<link href="../../bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="../../bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="../../bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="../../bootstrap/js/jquery-3.1.0.js"></script>
<script src="../../bootstrap/js/jquery-ui.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		//1.滑鼠滑入滑出時顯示圖片/文字
		$('#show #showsportname').hide();
		
		$('#show #showsportimg').each(function() {
			$(this).mouseover(function() {
				$(this).prev().show();  //sportName
				$(this).hide();  //sportImg
			});		
		});
		
		$('#show #showsportname').mouseout(function() {
			$('#show #showsportname').hide();  //sportName
			$('#show #showsportimg').show();  //sportImg
		});
		
		//2.按+時會將你所點選之項目加入以選擇區塊	
		$("input[name='sportId']").hide();
		$("input[name='calories']").hide();
		$("input[name='sportName']").hide();
		$("img[name='chooseimg']").hide();
		
		checkSport();  //一開始確認清單
		addSport();  //加入食物時
		checkCalories();  //確認目前攝取量
		
		
		$("button[name='submit']").each(function(){
			$(this).click(function(){	
				checkCalories();
			});  //end of click
		});  //end of submit button			
	});  //end of document ready
	
	
	
	
	
	
	
	function checkSport(){
		
		var url = "${pageContext.request.contextPath}/calculaties/sport/checkSport.do";
		console.log("url= "+url);
		
		$.get(url,function(data){
			console.log("data= "+data);  //回傳data
			$("#choose table").html(data);

		});
	}  //end of function checkSport
	
	function addSport(){
		$("button[name='submit']").each(function(){
			$(this).click(function(){
				var sportId = $(this).siblings(":nth-child(4)").val();
				console.log("sportId= "+sportId);
				
				var calories = $(this).siblings(":nth-child(5)").val();
				console.log("calories= "+calories);
				
				var sportName = $(this).siblings(":nth-child(6)").val();
				console.log("sportName= "+sportName);
				
				var quantity = $(this).siblings(":nth-child(8)").val();
				console.log("quantity= "+quantity);
				
				var url = "${pageContext.request.contextPath}/calculaties/sport/addSport.do?sportId="+
							sportId+"&quantity="+quantity+"&calories="+calories+"&sportName="+sportName;
				console.log("url= "+url);
				
				
				$.get(url,function(data){
					console.log("data= "+data);  //回傳data
					$("#choose table").html(data);

				});
			});  //end of click
		});  //end of submit button	
	}//end of function addSport

	
	function checkCalories(){
		
		var url = "${pageContext.request.contextPath}/calculaties/sport/checkCalories.do";
		console.log("url= "+url);
		
		$.get(url,function(data){
			console.log("data= "+data);  //回傳data
			$("#count").html(data);
			
		});
	}//end of function checkCalories

</script>

<style type="text/css">
	.canchoose{
		border:10px double #8EBEAE;
		height: 600px;
		width:70%;
		overflow: scroll;
		overflow-x:hidden ;
	}
	.chooseandcount{
		width:30%;
	}
	#showsportimg{
		height: 200px; 
 		width: 200px; 
		border: 2px solid #8EBEAE;
		margin: 15px;
		box-shadow:3px 3px 12px gray;
	}
	#showsportname{
		display:block;
		height: 200px;
		width: 200px;
		border: 2px solid #8EBEAE;
		margin: 15px;
		padding:70px 0px 0px 0px;
		box-shadow:3px 3px 12px gray;
		font-family: "微軟正黑體";
		font-size: 25px;
		text-align: center;
		vertical-align: middle;
	}
	.info{
		display:inline;
		text-align: center;
		font-size:22px;
		font-family: consolas;
	}
	.alreadychoose{
		display:block;
/* 		background: yellow; */
		height: 400px;
		font-family: 'consolas', '微軟正黑體', sans-serif;
		font-size: 22px;
		text-align: center;
		vertical-align: middle;
		border:10px double #8EBEAE;
		overflow: scroll;
		overflow-x:hidden ;
		margin: 1px;
	}
	.chooseinfo{
		 height: 70px;
		 padding: 15px 1px;
	}
	.choosecount{
		display:block;
		height: 200px;
		border:10px double #8EBEAE;
		margin: 1px;
		padding:50px 0px 0px 0px;
		font-family: 'consolas', '微軟正黑體', sans-serif;
		font-size: 26px;
		text-align: center;
		vertical-align: middle;
	}
	.qtystatus{
		 font-size: 22px;
		 width: 30px;
		 height: 30px;
		 line-height: 15px;
		 padding: 0px 0px 3px 0px;
	}
	.countbutton{
		font-size:22px;
		margin: 20px;
		letter-spacing: 5px;
	}
</style>
</head>
<body>
		
<jsp:include page="../../global/default.jsp" />
		
		
		<div class="container" style="height: 600px;width: 83%;">
			<div class="row">
			
				<!-- 可選擇 -->
				<div class="col-md-8 col-xs-8 canchoose">
					
					<c:forEach var="sport" items="${ShowSport}">
					<div class="col-md-3 col-xs-3 info">
						<div id="show">
							<div id="showsportname" style="background: url(/health/images/bg01.jpg) repeat">
							    <p>${sport.name}</p>
							</div>
							<div id="showsportimg">
								<img src='${pageContext.servletContext.contextPath}/getImage?id=${sport.id}&type=sport' 
							    	 style="width: 100%;height: 100%"/>		
							</div>
						</div>

					
					<br>
					
						<span style="margin: 0px 0px 0px 45px">${sport.calories} kcal</span>
						
						<input name="sportId" value="${sport.id}" />
						<input name="calories" value="${sport.calories}" />
						<input name="sportName" value="${sport.name}" />
									

						<br>
               			<select class="selectpicker" name="quantity" style="width: 80px;margin: 0px 0px 0px 45px" >
							<option value="1">1</option>
		                    <option value="2">2</option>
		                    <option value="3">3</option>
		                    <option value="4">4</option>
		                    <option value="5">5</option>
						</select>
						
						
               			<button type="submit" class="btn btn-info qtystatus" value="add" name="submit">+</button>
               			
               		</div>
					</c:forEach>
								
				</div>  <!-- 可選擇的end -->
				
				
				
				<div class="col-md-4 col-xs-4 chooseandcount" style="height: 600px">  <!-- background: blue; -->
					
					<!-- 目前所選取的 -->
					<div class="row alreadychoose">
						<div id="choose">
							<table>
									<!-- 放ajax傳回來的資料 -->
							</table>
						</div>					
					</div>

			
					<!-- 計算熱量總和 -->
					<div class="row choosecount">
						<div id="count">您尚未選取任何項目</div>
		
						<form action="<c:url value='/calculaties/sport/saverecord.do' />">
							<button type="submit" class="btn btn-info countbutton" value="保存" name="saveOrCancle">保存</button>
							<button type="submit" class="btn btn-info countbutton" value="清除" name="saveOrCancle">清除</button>
						</form>
					</div> <!-- end of choosecount -->
				</div>
			</div>
		</div>
		

		
		
<jsp:include page="../../global/default_bottom.jsp" />		

</body>
</html>