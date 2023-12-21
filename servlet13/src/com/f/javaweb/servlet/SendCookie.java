package com.f.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/12/14 12:55
 */
@WebServlet("/sendCookie")
public class SendCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies(); // 这个方法可能返回null，没有提交cookie的时候
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获取cookie的name
                String name = cookie.getName();
                // 获取cookie的value
                String value = cookie.getValue();
                System.out.println(name + " = " + value);
            }
        }
    }
}
