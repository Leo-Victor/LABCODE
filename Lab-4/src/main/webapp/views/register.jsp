<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/account/register" method="post">
    Full name: <input name="fullname"/><br/>
    Gender:
    <input type="radio" name="gender" value="male"/> Male
    <input type="radio" name="gender" value="female"/> Female<br/>
    Country:
    <select name="country">
        <option value="VN">Vietnam</option>
        <option value="US">USA</option>
        <option value="UK">UK</option>
    </select><br/>
    Hobbies:
    <input type="checkbox" name="hobby" value="Sport"/> Sport
    <input type="checkbox" name="hobby" value="Music"/> Music
    <input type="checkbox" name="hobby" value="Reading"/> Reading<br/>
    <button>Submit</button>
</form>

<p>${message}</p>
</body>
</html>