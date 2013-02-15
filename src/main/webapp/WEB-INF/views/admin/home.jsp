<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrator</title>
</head>
<body>
<p>hello</p>
	<table>
		<tr>
			<th>Name</th>
			<th>Status</th>
		</tr>
		<c:forEach var="staff" items="${staffs }">
			<tr>
				<td>${staff.firstName } ${staff.lastName }</td>
				<td>${staff.status }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>