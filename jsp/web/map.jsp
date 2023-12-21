<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.f.javaweb.jsp.bean.User " %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    // 一个Map集合
    Map<String,String> map = new HashMap<>();
    map.put("username", "zhangsan");
    map.put("password", "123");
    // 将Map集合存储到request域当中。
    request.setAttribute("userMap", map);

    // 另一个Map集合
    Map<String,User> map2 = new HashMap<>();
    User user = new User();
    user.setName("lisi");
    map2.put("user", user);
    request.setAttribute("userMap2", map2);
%>

<%--使用EL表达式，将map中的数据取出，并输出到浏览器--%>
${userMap.username}
<br>
${userMap.password}
<br>
${userMap["username"]}
<br>
${userMap["password"]}
<hr>

<%--使用EL表达式将map2中的user对象中的username取出--%>
${userMap2.user.name}