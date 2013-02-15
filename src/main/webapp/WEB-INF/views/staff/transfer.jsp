<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transfer Visitor</title>
</head>
<body>
	<sf:form action="/qms/staff/transferVisitor/${visitor.id }" commandName="visitor" method="POST">
		<sf:select path="staff">
			<sf:options items="${staffList}" itemValue="id" />
		</sf:select>
		<input type="submit" name="Submit" value="Submit">
	</sf:form>
</body>
</html>