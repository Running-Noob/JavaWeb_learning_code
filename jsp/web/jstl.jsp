<%@ page import="com.f.javaweb.jsp.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<%--需求：将List集合中的元素遍历。输出学生信息到浏览器--%>
<%--使用java代码--%>
<%
    // 从域中获取List集合
    List<Student> stus = (List<Student>) request.getAttribute("stuList");
    // 编写for循环遍历list集合
    for (Student stu : stus) {
%>
        name:<%=stu.getName()%>,age:<%=stu.getAge()%><br>
<%
    }
%>

<hr>

<%--使用core标签库中forEach标签。对List集合进行遍历--%>
<%--EL表达式只能从域中取数据。--%>
<%--items需要进行迭代的集合，var后面的名字是随意的。var属性代表的是集合中的每一个元素。--%>
<c:forEach items="${stuList}" var="s">
    name:${s.name},age:${s.age} <br>
</c:forEach>