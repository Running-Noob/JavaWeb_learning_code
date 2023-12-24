<%@ page import="com.f.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--核心标签库中的if标签--%>
<%--test属性是必须的。test属性支持EL表达式--%>
<c:if test="${empty param.username}">
    <h1>用户名不能为空。</h1>
</c:if>
<%--没有else标签, 可以搞两个if出来--%>
<c:if test="${not empty param.username}">
    <h1>欢迎${param.username}</h1>
</c:if>
<%--if标签还有var属性，不是必须的。--%>
<%--if标签还有scope属性，用来指定var的存储域。也不是必须的。--%>
<%--scope有四个值可选：page(pageContext域)、request(request域)、session(session域)、application(application域)--%>
<%--将var中的v存储到request域。--%>
<%--把test的值以var为键名保存到指定的域中--%>
<c:if test="${not empty param.username}" var="v" scope="request">
    <h1>欢迎你${param.username}。</h1>
</c:if>
<%--通过EL表达式将request域中的v取出--%>
${v}<br/>

<hr/>

<%--核心标签库中的forEach标签--%>
<%--var用来指定循环中的变量--%>
<%--begin开始--%>
<%--end结束--%>
<%--step步长--%>
<%--底层实际上：会将i存储到pageContext域当中。--%>
<c:forEach var="i" begin="1" end="10" step="1">
    <%--所以这里才会使用EL表达式将其取出，EL表达式取数据一定是从某个域当中取出的。--%>
    ${i}<br>
</c:forEach>

<%
    // 创建List集合
    List<Student> stuList = new ArrayList<>();
    // 创建Student对象
    Student s1 = new Student("张三", 10);
    Student s2 = new Student("李四", 20);
    Student s3 = new Student("王五", 30);
    // 添加到List集合中
    stuList.add(s1);
    stuList.add(s2);
    stuList.add(s3);
    // 将list集合存储到request域当中
    request.setAttribute("stuList", stuList);
%>
<%--var="s"这个s代表的是集合中的每个Student对象--%>
<%--varStatus="这个属性表示var的状态对象，这里是一个java对象，这个java对象代表了var的状态"--%>
<%--varStatus="这个名字是随意的"--%>
<%--varStatus这个状态对象有count属性。可以直接使用。--%>
<c:forEach items="${stuList}" var="s" varStatus="stuStatus">
    <%--varStatus的count值从1开始，以1递增，主要是用于编号/序号。--%>
    编号：${stuStatus.count}, name:${s.name}, age:${s.age} <br>
</c:forEach>

<hr/>

<%--核心标签库中的choose标签--%>
<c:choose>
    <c:when test="${param.age < 18}">
        少年
    </c:when>
    <c:when test="${param.age < 35}">
        青年
    </c:when>
    <c:when test="${param.age < 55}">
        中年
    </c:when>
    <c:otherwise>
        老年
    </c:otherwise>
</c:choose>