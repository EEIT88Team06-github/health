
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">  <!-- Bootstrap -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css" rel="stylesheet">  <!-- jQuery -->
<link href="${pageContext.servletContext.contextPath}/bootstrap/templatecss/health.css" rel="stylesheet">  <!-- template -->
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
<script src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/global/default.jsp" />
	<c:set var="orderTotal" value="${orderTotal = 0 }"/>

	<div class="container" style="height: 800px;width: 700px; vertical-align: middle">
<%-- 		<c:if test="${empty cartBeans }"> --%>
<!-- 			<hr> -->
<!-- 		<script>document.location.href="<c:url value='/shopping/Products?intend=selectAll'/>";</script> -->
<%-- 		</c:if> --%>
		
		<c:if test="${! empty cartBeans }">
			<c:forEach items="${cartBeans}" var="cartBeans">
<!-- 				<hr> -->
<%-- 				<c:out value="${cartBeans.prodId}" /> --%>
<%-- 				<c:out value="${cartBeans.quantity}" /> --%>
<%-- 				<c:out value="${cartBeans.total}" /> --%>
				<c:set var="cbtotal" value="${cartBeans.total }"/>
				本次購物可折抵:${orderTotal = orderTotal + cbtotal}元
			</c:forEach>
		</c:if>
		
		
		<c:forEach items="${cartBeans}" var="cartBeans">
			<form action="${pageContext.servletContext.contextPath}/shopping/Cart" method="post" onsubmit="return confirm('Sure?');">
				
<!-- 				<input type="hidden" name="type" value="change" />" /> -->
				<input type="hidden" name="intend" value="change" />
				<input type="hidden" name="prodId" value="${cartBeans.prodId }" />
				<input type="hidden" name="ordNum" value="${cartBeans.ordNum }" />
				<input type="hidden" name="memId" value="<c:out value="${LoginOK.id}" />" />
				<table>
					<tr>
						<td><c:out value="${cartBeans.prodName}" /></td>
						<td>${cartBeans.quantity }</td>
						<td>
								<c:set var="prodId" value="${cartBeans.prodId }" />
								<select name="number" id="select${cartBeans.prodId }">
									<c:forEach var="myData" begin="1" end="${orderProduct[prodId].quantity}"
											step="1">
											<option value="${myData}" ${myData == cartBeans.quantity  ? 'selected="selected"' : ''}>${myData}</option>										
									</c:forEach>
								</select>
						</td>
<%-- 										${orderProduct.quantity == cartBeans.quantity ? 'selected="selected"' : '' }>${myData}</option> --%>
						<td><c:out value="${cartBeans.total}" /></td>
						
						<td><div><input class="btn btn-default" type="submit" name="type" value="修改" /> <input
							class="btn btn-default" type="submit" name="type" value="刪除" /></div></td>
						
					</tr>
				</table>
			</form>
		</c:forEach>
		

	
	<c:set var="bonusCal" value="${orderTotal*0.1 }"/>
	${bonusCal }
	<hr>
	本次可使用的紅利積點為
		<c:if test="${LoginOK.bonus gt bonusCal }">
			${bonusCal }
		</c:if>
		<c:if test="${bonusCal gt LoginOK.bonus }">
			${LoginOK.bonus }
		</c:if> 
		
		
	<hr>
	總金額為:${orderTotal}
	<hr>
	<form action="${pageContext.servletContext.contextPath}/shopping/Order?intend=orderConfirm" method="post">
		請選擇付款方式:
		<hr>
<%-- 		<input type="hidden" name="memId" value="<c:out value="${LoginOK.id}" />" > --%>
		<input type="hidden" name="intend" value="orderConfirm" />
		<c:set var="finalTotal" value="${orderTotal}" scope="session"  />
		<input type="hidden" name="bonus" value="<c:out value="${LoginOK.id}" />" >
<%-- 		<input type="hidden" name="orderTotal" value="<c:out value="${orderTotal}" />" > --%>
		<input type="hidden" name="" value="">
		
		<input class="btn btn-default" type="submit" name="orderSubmit" value="貨到付款">
		<input class="btn btn-default" type="submit" name="orderSubmit" value="超商取貨">
		<input class="btn btn-default" type="submit" name="orderSubmit" value="信用卡付款">
		<input class="btn btn-default" type="submit" name="orderSubmit" value="匯款轉帳">
	</form>
	</div>
	<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>