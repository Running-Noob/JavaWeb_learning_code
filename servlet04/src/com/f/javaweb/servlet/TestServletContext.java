package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/11/22 16:50
 */
public class TestServletContext extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 1.通过 `ServletConfig` 对象获取 `ServletContext` 对象。
        ServletConfig config = this.getServletConfig();
        ServletContext application1 = config.getServletContext();
        out.print("ServletContext: " + application1);
        out.print("<br/>");

        // 2.通过 `this` 也可以获取 `ServletContext` 对象。
        ServletContext application2 = this.getServletContext();
        out.print("ServletContext: " + application2);
        out.print("<br/>");
    }
}
