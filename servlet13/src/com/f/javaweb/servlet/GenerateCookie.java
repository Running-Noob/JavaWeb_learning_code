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
 * @date 2023/12/13 21:25
 */
@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 创建cookie对象
        Cookie cookie1 = new Cookie("productId", "A123");
        Cookie cookie2 = new Cookie("name", "zhangsan");

        // 设置cookie在一小时之后失效（保存在硬盘文件中）
        //cookie.setMaxAge(60 * 60);
        // 设置cookie的有效期为0，表示该cookie被删除，主要应用在：使用这种方式删除浏览器客户端上的同名cookie
        //cookie.setMaxAge(0);
        // 设置cookie的有效期 < 0，表示该cookie不会被存储在硬盘，只是保存在浏览器运行内存中
        //cookie.setMaxAge(-1);

        // 默认情况下，没有设置path的时候，cookie关联的路径是什么，是 `“/项目名/当前路径的上一层地址”
        // 设置cookie的路径
        cookie1.setPath(request.getContextPath());   //表示只要是在该应用下，都发送这个cookie给服务端
        cookie2.setPath(request.getContextPath());

        // 将cookie响应到浏览器
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
