package com.f.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/12/7 19:50
 */
@WebServlet("/test/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // 获取session对象
        // 从Web服务器当中获取当前的session对象，如果session对象没有，则新建
        HttpSession session = request.getSession();

        //// 从Web服务器当中获取当前的session对象，如果session对象没有，并不会新建，返回null
        //HttpSession session = request.getSession(false);

        out.print("session对象 = " + session); // 看看session对象的内存地址

        // 向会话域中存数据
        //session.setAttribute();
        // 从会话域中取数据
        //session.getAttribute();
    }
}
