package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/11/22 15:08
 */
public class TestServletConfig2 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        // 输出该对象
        //ServletConfig: org.apache.catalina.core.StandardWrapperFacade@607693fa
        out.print("ServletConfig: " + config);
    }
}
