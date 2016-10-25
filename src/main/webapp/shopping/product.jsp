<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Bootstrap -->
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/css/jquery-ui.min.css"
	rel="stylesheet">
<!-- jQuery -->
<link
	href="${pageContext.servletContext.contextPath}/bootstrap/templatecss/health.css"
	rel="stylesheet">
<!-- template -->
<script
	src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-3.1.0.js"></script>
<script
	src="${pageContext.servletContext.contextPath}/bootstrap/js/jquery-ui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${one.name }</title>
</head>
<body>
	<jsp:include page="/global/default.jsp" />

<%-- 	<c:if test="${empty cartBeans }"> --%>
<!-- 		<hr> -->
<!-- 		no cart -->
<%-- 	</c:if> --%>
<%-- 	<c:if test="${! empty cartBeans }"> --%>
<%-- 		<a href="<c:url value='/shopping/Order?intend=check&type=check'/>">結帳</a> --%>
<%-- 		<c:forEach items="${cartBeans}" var="cartBeans"> --%>
<!-- 			<hr> -->
<%-- 			cart ordName: <c:out value="${cartBeans.prodName}" /> --%>
<!-- 			<br> -->
<%-- 	cart ordNum: <c:out value="${cartBeans.ordNum}" /> --%>
<!-- 			<br> -->
<%-- 	cart prodID: <c:out value="${cartBeans.prodId}" /> --%>
<!-- 			<br> -->
<%-- 	cart quantity: <c:out value="${cartBeans.quantity}" /> --%>
<!-- 			<br> -->
<%-- 	cart total <c:out value="${cartBeans.total}" /> --%>
<!-- 			<br> -->
<%-- 		</c:forEach> --%>
<%-- 	</c:if> --%>
<!-- 	<hr> -->
<%-- 	<h1>${LoginOK.id }</h1> --%>
<!-- 	<hr> -->

	<div id="banner" class="container"
		style="height: 800px; width: 700px; vertical-align: middle">

		<div>
			<table>
				<tr>
					<td>Product Pic: <img
						src="<c:url value='/shopping/Products?intend=selectPic&id=${one.id}' />" /></td>
				</tr>
				<tr>
					<td><a>追蹤此商品</a></td>
				</tr>
				<tr>
					<td>Product Name: <c:out value="${one.name}" /></td>
				</tr>
				<tr>
					<td>Product Price: <c:out value="${one.price}" /></td>
				</tr>
				<tr>
					<td>Product total: <c:out value="${one.total}" /></td>
				</tr>
				<tr>
					<td>Product content: <c:out value="${one.content}" /></td>
				</tr>
				<tr>
					<td><c:if test="${ one.quantity  != 0}">

							<form
								action="${pageContext.servletContext.contextPath}/shopping/Cart?check=add"
								method="post">


								<input type="hidden" name="check" value="add" />" /> <input
									type="hidden" name="type" value="add" />" /> <input
									type="hidden" name="prodId" value="<c:out value="${one.id}" />" />
								<input type="hidden" name="memId"
									value="<c:out value="${LoginOK.id}" />" /> <input
									type="hidden" name="ordNum" value="<c:out value="${ordNum}" />" />
								<select name="number" id="select${one.id }"
									onchange="quantity()">
									<c:forEach var="myData" begin="1" end="${one.quantity}"
										step="1">
										<c:if test="${! empty cartBeans }">
											<c:set var="prodId" value="${one.id }" />
											<c:set var="quantity" value="${quantityMap[prodId]}" />
											<option value="${myData}"
												${myData == quantity  ? 'selected="selected"' : ''}>${myData}</option>
										</c:if>
										<c:if test="${ empty cartBeans }">
											<option value="${myData}">${myData}</option>
										</c:if>
									</c:forEach>
								</select>
								<div class="control-group">
									<label class="control-label">Button</label>

									<!-- Button -->
									<div class="controls">
										<button class="btn btn-success">Button</button>
									</div>
								</div>
								<div class="control-group">
									<input class="btn btn-default" type="submit" value="加入購物車" />
									<c:if test="${! empty cartBeans }">
										<a
											href="<c:url value='/shopping/Order?intend=check&type=check'/>">結帳</a>
									</c:if>
							</form>
						</c:if> <c:out value="${myValue}" /> <c:if test="${ one.quantity == 0}">
							<font color="red">已售完</font>
							<span><a
								href="<c:url value='/shopping/Notice?intend=add' />">貨到通知</a></span>
						</c:if></td>
				</tr>
			</table>

		</div>

		<br>
		<hr>

		<%-- 				<img src="${pageContext.servletContext.contextPath}/images/header-photo.jpg" width="1200" height="400" alt="" /> --%>
	</div>

	<div id="three-column" class="container"></div>
	<jsp:include page="/global/default_bottom.jsp" />
</body>
</html>