package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author fzy
 * @date 2023/11/22 14:43
 */
public class TestServletConfig extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取<servlet-name></servlet-name>
        String servletName = this.getServletName();
        out.print("<servlet-name>" + servletName + "</servlet-name>");
        out.print("<br/>");

        // java.util.Enumeration<java.lang.String>	getInitParameterNames() 获取所有的初始化参数的name
        Enumeration<String> initParameterNames = this.getInitParameterNames();
        // 遍历集合
        while (initParameterNames.hasMoreElements()) { // 是否有更多元素
            String parameterName = initParameterNames.nextElement(); // 取元素
            String parameterVal = this.getInitParameter(parameterName); // 通过name获取value
            out.print(parameterName + "=" + parameterVal);
            out.print("<br/>");
        }
    }
}