<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Staff Form (BeanUtils)</h2>

<form action="${pageContext.request.contextPath}/save" method="post">
    Fullname: <input name="fullname" value="${param.fullname}"/><br/>
    Birthday (MM/dd/yyyy): <input name="birthday" value="${param.birthday}"/><br/>
    Gender:
    <input type="radio" name="gender" value="true"/> Male
    <input type="radio" name="gender" value="false"/> Female<br/>
    Hobbies:
    <input type="checkbox" name="hobbies" value="R"/> Reading
    <input type="checkbox" name="hobbies" value="Traveling"/> Traveling
    <input type="checkbox" name="hobbies" value="M"/> Music<br/>
    Country:
    <select name="country">
        <option value="VN">Việt Nam</option>
        <option value="US" selected>United States</option>
    </select><br/>
    Salary: <input name="salary" value="${param.salary}"/><br/>
    <button>Submit</button>
</form>

<c:if test="${not empty staff}">
    <h3>Submitted Staff (server-side)</h3>
    <pre>${staff}</pre>
</c:if>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<hr>
<a href="${pageContext.request.contextPath}/send-mail">Go to Mail Form</a> |
<a href="${pageContext.request.contextPath}/login">Login page</a>
</body>
</html>