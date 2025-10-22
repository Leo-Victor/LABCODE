<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en";
    pageContext.setAttribute("lang", lang);
%>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="global" var="g" />

<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8"/>
    <title><fmt:message key="site.title" bundle="${g}"/></title>
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        header, footer { background: #003366; color: white; padding: 10px 20px; }
        nav { background: #f0f0f0; padding: 8px 20px; }
        main { padding: 20px; min-height: 300px; background: #fff; }
        .container { max-width: 900px; margin: 0 auto; }
        a { text-decoration: none; color: #003366; }
    </style>
</head>
<body>
<div class="container">
<header>
    <h1><fmt:message key="site.header" bundle="${g}"/></h1>
</header>
<nav>
    <hr/>
    <c:url value="/home" var="base" />
    <a href="${base}/index"><fmt:message key="menu.home" bundle="${g}"/></a> |
    <a href="${base}/about"><fmt:message key="menu.about" bundle="${g}"/></a> |
    <a href="${base}/contact"><fmt:message key="menu.contact" bundle="${g}"/></a>
    <span style="float:right;">
        <a href="?lang=en">English</a> |
        <a href="?lang=vi">Tiếng Việt</a>
    </span>
    <hr/>
</nav>
<main>
    <jsp:include page="${view}" />
</main>
<footer>
    <hr/> &copy; <fmt:message key="site.copy" bundle="${g}"/>
</footer>
</div>
</body>
</html>