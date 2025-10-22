<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
	<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
	<fmt:setBundle basename="home" var="h" />
	<fmt:setBundle basename="i18n.home" var="h" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="home.title" bundle="${h}"/></title>
</head>
<body>
	<%-- <fmt:setBundle basename="home" var="h" /> --%>
	<h1><fmt:message key="home.title" bundle="${h}"/></h1>
	<p><fmt:message key="home.welcome" bundle="${h}"/></p>
</body>
</html>