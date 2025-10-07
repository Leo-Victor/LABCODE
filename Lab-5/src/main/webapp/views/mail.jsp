<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Send Mail</title></head>
<body>
<h2>Send Mail</h2>
<form action="${pageContext.request.contextPath}/send-mail" method="post">
    From: <input name="from" value="${param.from}"/><br/>
    To: <input name="to" value="${param.to}"/><br/>
    Subject: <input name="subject" value="${param.subject}"/><br/>
    Body:<br/>
    <textarea name="body" rows="8" cols="60">${param.body}</textarea><br/>
    <button>Send</button>
</form>
</body>
</html>
