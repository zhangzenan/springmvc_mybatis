<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查询商品列表</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
	查询条件：
	<table width="100%" bolder=1>
		<tr>
			<td>
				商品名称：<input name="itemsCustom.name"/>
			</td>
			<td>
				<input type="submit" value="查询"/>
			</td>			
		</tr>		
	</table>
	<table width="100%" bolder=1>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>			
			<td>商品描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${itemsList}" var="item">
			<tr>
				<td>${item.name }</td>
				<td>${item.price }</td>			
				<td>${item.detail }</td>
				<td>
					<a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	</form>

</body>
</html>