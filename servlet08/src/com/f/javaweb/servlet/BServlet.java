package com.f.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author fzy
 * @date 2023/11/28 19:38
 */
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 从request域中获取数据
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Date sysTime = (Date) request.getAttribute("sysTime");
        out.print("BSerlvet从request域中获取的系统的当前时间: " + sysTime + "<br/>");
    }
}