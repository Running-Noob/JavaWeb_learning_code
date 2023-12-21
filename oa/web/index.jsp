<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    用户名: <input type="text" name="username"><br/>
    密 码: <input type="password" name="pwd"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>