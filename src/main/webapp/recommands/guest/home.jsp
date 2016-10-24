<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- ****************************************************************** -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="subTitle" value="今日推薦" scope="session" />





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



	<script>
		$( function() {
 		  $( "#dialog-message" ).dialog({
 			height: 400,
 			width:400,
 		    modal: true,
 		   	closeOnEscape: false,//按ESC不能關閉
 		  	open: function(event, ui) {
 		    //隱藏「x」關閉按鈕
 		    $(this).parent().children().children('.ui-dialog-titlebar-close').hide();
 		    }
 		  });
 		} );
	</script> 


<style type="text/css">
	.recommand{
		width: 700px;
		height:500px ;
		border: 50px double #FF9797;
		margin: 20px;
		-moz-background-size: cover;
    	background-size: cover;
	}
	.subject{
		font-family: 微軟正黑體;
		font-size: 36px;
		color: gray;
		text-align: center;"
	}
	p{
		font-family: 微軟正黑體;
		font-size: 18px;
		color: gray;
		line-height: 26px;
	}
	.formcontent{
		font-family:微軟正黑體;
		font-size: 18px;
		width: 60px;
		color: gray;
		line-height: 40px;
	}
	.option{
		font-family:微軟正黑體;
		font-size: 18px;
		width: 60px;
		color: gray;
		line-height: 40px;
	}
	.errorMsg{
		color: red;
		font-size: 18px;
		font-family: 微軟正黑體;
		font-style: italic;
		margin: 3px;
	}
</style>
</head>
<body>
		
<jsp:include page= "../../global/default.jsp" />
		
		
		<div class="container" style="width: 1500px;-moz-background-size: cover;background-size: cover;">
			<div class="row" style="background:url(/health/images/bg01.jpg) repeat;">
				<form action="<c:url value='/recommands/what.do' />" method="post">
					<div class="col-md-6 col-xs-6">
						<input type="image" src="../img/recommandFood.jpg" alt="submit" name="recommand" value="food" class="recommand"/>
					</div>
					<div class="col-md-6 col-xs-6">
						<input type="image" src="../img/recommandSport.jpg" alt="submit" name="recommand" value="sport" class="recommand"/>
					</div>
				</form>
			</div>
			<div class="row">
				<div class="col-md-6 col-xs-6 subject">食譜推薦</div>
				<div class="col-md-6 col-xs-6 subject">運動推薦</div>
			</div>
		</div>
		
		
		
		<div id="dialog-message" title="BMI計算">
  				<form action="<c:url value='/recommands/guest/calculaties/guestbmi.do' />" method="post">
  				
  					<p>親愛的訪客您好，此功能需登入會員方可使用，若您想接受我們的推薦，請留下以下資訊讓我們為您計算出最適合您的餐點。</p>
  					<hr style="border: 2px dotted gray">

					<table>
						<tr><td class="formcontent">身高：</td>
							<td><input type="text" name="heights" id="heights" value=${backFill.height}>
								<span class="errorMsg">${error.height}</span>
							</td>
						</tr>
						
						
						<tr><td class="formcontent">體重：</td>
							<td><input type="text" name="weights" id="weights" value=${backFill.weight} >
								<span class="errorMsg">${error.weight}</span>
							</td>
						</tr>
						
						<tr>
							<td class="formcontent">性別：</td>
							<td><input type="radio" name="gender" id="F" value="女" checked="checked"><span class="option">女生  </span>
								<input type="radio" name="gender" id="M" value="男"><span class="option">男生</span>
								<span class="errorMsg">${error.gender}</span>
							</td>
						</tr>
						
						<tr>	
							<td class="formcontent">推薦：</td>
							<td><input type="radio" name="recommand" id="food" value="food"  checked="checked"><span class="option">食譜</span>
								<input type="radio" name="recommand" id="sport" value="sport"><span class="option">運動</span>
								<span class="errorMsg">${error.recommand}</span>
							</td>				
						</tr>
						
						<tr><td><input type="submit" class="btn btn-info" value="Submit"></td></tr>
					</table>
				</form>

		</div>
 

 
		
		
<jsp:include page= "../../global/default_bottom.jsp" />		

</body>
</html>