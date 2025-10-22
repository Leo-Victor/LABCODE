<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
    <fmt:setBundle basename="home" var="h" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1><fmt:message key="contact.title" bundle="${h}"/></h1>
	<p><fmt:message key="contact.content" bundle="${h}"/></p>
</body>
</html>