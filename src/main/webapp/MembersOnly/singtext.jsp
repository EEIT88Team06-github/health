<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/JavaScript" src="../js/jquery-3.1.0.js"></script>
<link rel="stylesheet" type="text/css" href="../css/singtext.css" />
<script type="text/JavaScript" src="../js/singtext.js"></script>
<script type="text/JavaScript">
$(function(){
 
	
	

	var signList = [ {
			"signDay" : "10"
		}, {
			"signDay" : "11"
		}, {
			"signDay" : "12"
		}, {
			"signDay" : "13"
		} ];
		calUtil.init(signList);
	});
	
</script>
</head>
<body>
	<div style="width: 300px; height: 300px;" id="calendar"></div>
	<li>上次簽到日期</li>
	<label></label>
	<li>連續次數</li>
	<li>今日是否是否簽到</li>

</body>
</html>