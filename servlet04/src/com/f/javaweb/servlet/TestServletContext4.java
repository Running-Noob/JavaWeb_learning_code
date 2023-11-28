package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/11/23 10:50
 */
public class TestServletContext4 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext application = this.getServletContext();
        /**
         * 1.`public void setAttribute(String name, Object value);` 向 ServletContext 应用域中存数据。
         */
        application.setAttribute("name", "jack");
        /**
         * 2.`public Object getAttribute(String name);` 从 ServletContext 应用域中取数据。
         */
        Object name = application.getAttribute("name");
        out.print(name);
        /**
         * 3.`public void removeAttribute(String name);` 删除 ServletContext 应用域中的数据。
         */
        application.removeAttribute("name");
    }
}
