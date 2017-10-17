<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${all}" var="poitem">
	<tr>
		<td>${poitem.productcode}</td>
		<td>${poitem.name}</td>
		<td>${poitem.unitname}</td>
		<td>${poitem.num}</td>
		<td>${poitem.unitprice}</td>
		<td>${poitem.itemprice}</td>
	</tr>
</c:forEach>
