<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式语法</title>
</head>
<body>
<%
    pageContext.setAttribute("username", "pageContext");
%>
${username}
</body>
</html>
