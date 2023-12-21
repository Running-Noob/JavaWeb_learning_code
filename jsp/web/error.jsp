<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>error page</title>
</head>
<body>
<h1>发生错误！</h1>
<%
    exception.printStackTrace();
%>
</body>
</html>
