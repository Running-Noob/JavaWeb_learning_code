package com.f.javaweb.servlet;

import com.f.javaweb.bean.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/12/5 21:22
 */
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();

        // 创建user对象
        User user = new User();
        user.setId(1);
        user.setName("小明");

        // 将user对象存储到请求域中
        request.setAttribute("userObj", user);

        // 转发
        //request.getRequestDispatcher("/b").forward(request, response);

        // 重定向
        response.sendRedirect(contextPath + "/b");
    }
}
