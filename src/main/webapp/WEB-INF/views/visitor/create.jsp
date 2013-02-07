<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Request</title>
</head>
<body>
	<sf:form method="POST" modelAttribute="visitor" action="create">
		<sf:label path="firstName">First Name:</sf:label>
		<sf:input path="firstName" />
		<sf:errors path="firstName" cssClass="error" />
		<br />
		<sf:label path="lastName">Last Name:</sf:label>
		<sf:input path="lastName" />
		<sf:errors path="lastName" cssClass="error" />
		<br />
		<sf:label path="purpose">Purpose:</sf:label>
		<sf:input path="purpose" />
		<sf:errors path="purpose" cssClass="error" />
		<br />

		<sf:select path="staff">
			<sf:options items="${staffList}" itemValue="id" />
		</sf:select>
		<input name="submit" type="submit" value="Submit" />
	</sf:form>
</body>
</html>