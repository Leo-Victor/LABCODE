<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Danh sách quốc gia (Select Box)</h3>
    <select name="country">
        <c:forEach var="ct" items="${countries}">
            <option value="${ct.id}">${ct.name}</option>
        </c:forEach>
    </select>

    <h3>Danh sách quốc gia (Table)</h3>
    <table border="1">
        <thead>
        <tr>
            <th>No.</th>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ct" items="${countries}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${ct.id}</td>
                <td>${ct.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>