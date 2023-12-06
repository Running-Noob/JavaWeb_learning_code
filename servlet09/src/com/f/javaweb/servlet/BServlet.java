package com.f.javaweb.servlet;

import com.f.javaweb.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/12/5 21:23
 */
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 得到请求域中的user对象
        User user = (User) request.getAttribute("userObj");
        out.print("AServlet传过来的user对象为: " + user);
    }
}
