<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="description" />
<style type="text/css">
* {
	
	margin: 0;
	padding: 0;
	list-style-type: none;
}
a, img {
	border: 0;
	text-decoration: none;
}

.singer {
	/* 	border: 1px solid #DCDBDB; */
	
	padding: 10px;
	height: 45px;
	line-height: 45px;
	width: 290px;
	margin: 20px auto;
}

.singer_l_cont {
	float: left;  
}

.singer_l_cont {
	width: 145px;
	text-indent: 23px;
	font-size: 12px;
}

.singer_r_img {
	z-index:2;
	float: left;
	display: block;
	width: 114px;
	height: 52px;
	background: url( "${pageContext.request.contextPath}/MbOnlyimages/images.png")
				 right 2px no-repeat;
	vertical-align: middle;
/*  	float: right;  */
	*margin-bottom: -10px;
}

.singer_r_img:hover {
	background-position: right -53px;
	text-decoration: none;
}

.singer_r_img span {
	margin-left: 14px;
	font-size: 16px;
	font-family: 'Hiragino Sans GB', 'Microsoft YaHei',
		sans-serif !important;
	font-weight: 700;
	color: #165379;
}

.singer_r_img.current {
	background:
/* 		url(/images/sing_sing.gif) */
		url(http://hovertree.com/texiao/jquery/50/images/sing_sing.gif)
		no-repeat 0 2px;
}

.hovertreecenter {
	text-align: center;
}
</style>
<script type="text/javascript" src="js/jquery.layerModel.js"></script>

<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
</head>

<body>

<div class="hovertreecenter"><h2></h2></div>

<div class="singer" style=" width: 150px ;margin-right: 0px" >
<div class="singer_l_cont">
<span></span>
</div>
	<form action="JspServlet?action=toServlet" method="get">
		<div class="singer_r_r">
			<a class="singer_r_img" id="prodaction" charset="Insert" >
				<span id="sing_for_number"></span>
			</a>
		</div>
	</form>	
		
	</div>
	
<div class="hovertreecenter">
<a href="http://hovertree.com" target="_blank"></a>
 <a href="http://hovertree.com/texiao/"></a>
<a href="http://hovertree.com/h/bjaf/hovertreetrain.htm"></a>
 </div>
<script src="http://down.hovertree.com/jquery/jquery-1.12.3.min.js"></script>
	<script type="text/javascript">
		function week() {
			var objDate = new Date();
			var week = objDate.getDay();
			switch (week) {
			case 0:
				week = "周日";
				break;
			case 1:
				week = "周一";
				break;
			case 2:
				week = "周二";
				break;
			case 3:
				week = "周三";
				break;
			case 4:
				week = "周四";
				break;
			case 5:
				week = "周五";
				break;
			case 6:
				week = "周六";
				break;
			}

			$("#sing_for_number").html(week);
		}

		$(document).ready(function() {
			week();

			$(".singer_r_img").click(function() {
				$(this).addClass("current");
			})
		})
	</script>

</body>
</html>