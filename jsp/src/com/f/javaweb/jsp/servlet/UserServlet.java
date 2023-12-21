package com.f.javaweb.jsp.servlet;

import com.f.javaweb.jsp.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/12/14 18:02
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 存入请求域中的User对象
        User user1 = new User();
        user1.setName("张三");
        user1.setAge(10);
        request.setAttribute("user", user1);
        // 存入应用域中的User对象
        User user2 = new User();
        user2.setName("李四");
        user2.setAge(20);
        request.getServletContext().setAttribute("user", user2);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }
}
