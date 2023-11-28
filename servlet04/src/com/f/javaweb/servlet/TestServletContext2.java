package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author fzy
 * @date 2023/11/22 21:04
 */
public class TestServletContext2 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext application = this.getServletContext();
        // 获取上下文的初始化参数
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        /**
         * 浏览器显示：
         * startIndex = 0
         * pageSize = 30
         */
        while (initParameterNames.hasMoreElements()) {
            String paramName = initParameterNames.nextElement();
            String paramVal = application.getInitParameter(paramName);
            out.print(paramName + " = " + paramVal + "<br/>");
        }
    }
}
