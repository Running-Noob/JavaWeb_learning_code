<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/error.jsp" %>
<html>
<head>
    <title>user</title>
</head>
<body>
${user.age}
<br/>
application域中的User对象: ${applicationScope.user.name}
<br/>
</body>
</html>
