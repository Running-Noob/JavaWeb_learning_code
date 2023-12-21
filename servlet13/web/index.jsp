<%--
  Created by IntelliJ IDEA.
  User: Running Noob
  Date: 2023/12/13
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cookie</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/cookie/generate">服务器生成cookie，然后将cookie响应给浏览器，浏览器接收cookie，将cookie放到客户端上</a><br/>
<a href="<%=request.getContextPath()%>/sendCookie">在服务器控制台打印浏览器发送给服务器的cookie</a>
</body>
</html>
