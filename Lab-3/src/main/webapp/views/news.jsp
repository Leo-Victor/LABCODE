<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>Thông tin bản tin</h3>
    <ul>
        <li>Title: ${fn:toUpperCase(item.title)}</li>
        <li>Content: 
            <c:choose>
                <c:when test="${fn:length(item.content) > 100}">
                    ${fn:substring(item.content, 0, 100)}...
                </c:when>
                <c:otherwise>
                    ${item.content}
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
</body>
</html>