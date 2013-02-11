<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff</title>
</head>
<body>
	<c:choose>
		<c:when test="${service eq 'serve' }">
			<p>Name : ${visitor.firstName } ${visitor.lastName }</p>
			<p>Purpose : ${visitor.purpose }</p>
			<a href="../../staff/done">Done</a>
		</c:when>
		<c:otherwise>
			<p>Name : ${visitor.firstName } ${visitor.lastName }</p>
			<p><a href="serve/${visitor.id }">Serve</a></p>
			<p><a>Transfer</a></p>
			<input type="submit" value="Transfer" name="submit" onclick=""/>
		</c:otherwise>
	</c:choose>
</body>
</html>