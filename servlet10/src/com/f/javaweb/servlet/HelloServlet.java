package com.f.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author fzy
 * @date 2023/12/6 11:55
 */
@WebServlet(name = "hello", urlPatterns = {"/hello1", "/hello2", "/hello3"}, loadOnStartup = 1,
        initParams = {@WebInitParam(name = "username", value = "admin"), @WebInitParam(name = "pwd", value = "123")})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String servletName = this.getServletName();
        out.print("Servlet名称为: " + servletName + "<br/>");

        String servletPath = request.getServletPath();
        out.print("ServletPath为: " + servletPath + "<br/>");

        Enumeration<String> initParameterNames = this.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = this.getInitParameter(name);
            out.print(name + " = " + value + "<br/>");
        }
    }
}
