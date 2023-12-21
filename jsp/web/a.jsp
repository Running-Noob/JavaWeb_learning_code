<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/error.jsp" %>
<html>
<head>
    <title>a</title>
</head>
<body>
<%
    out.print(1 / 0);
%>
</body>
</html>