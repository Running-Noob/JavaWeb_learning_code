package com.f.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * 用于判断跳转到登录成功页面还是登录失败页面
 *
 * @author fzy
 * @date 2023/12/8 11:33
 */
@WebServlet("/jump")
public class JumpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取session对象，如果session对象不存在，则返回null
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {    // session条件判断
            // 这里写的比较简陋，完整的应该是如果条件成立，
            // 就会执行数据相关的crud操作，然后带着数据跳转到相应的页面
            // 所以如果直接访问 ip:port/xxx/xxx.jsp 是不会显示数据的
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } else {
            response.sendRedirect(request.getContextPath());
        }
    }
}
