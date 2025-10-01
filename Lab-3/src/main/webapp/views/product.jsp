<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h3>Thông tin sản phẩm</h3>
    <ul>
        <li>Name: ${item.name}</li>
        <li>Price: <fmt:formatNumber value="${item.price}" pattern="#,###.00"/></li>
        <li>Date: <fmt:formatDate value="${item.date}" pattern="MMM dd, yyyy"/></li>
    </ul>
</body>
</html>