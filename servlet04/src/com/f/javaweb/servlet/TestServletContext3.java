package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author fzy
 * @date 2023/11/22 21:25
 */
public class TestServletContext3 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext application = this.getServletContext();
        /**
         * 1.`public String getContextPath();` 获取应用的根路径。
         * 因为在java源代码当中有一些地方可能会需要应用的根路径，这个方法可以动态获取应用的根路径。
         * 在java源码当中，不要将应用的根路径写死，因为你永远都不知道这个应用在最终部署的时候，会起一个什么名字。
         */
        String contextPath = application.getContextPath();
        out.print(contextPath + "<br/>");   // "/context"
        /**
         * 2.`public String getRealPath(String path);` 获取文件的绝对路径（真实路径）.
         * 传入的参数中，加了一个“/”，这个“/”代表的是web的根
         * String realPath = application.getRealPath("/index.html"); // 可以
         * 你不加“/”，默认也是从根下开始找。
         * String realPath = application.getRealPath("index.html"); // 不加“/”也可以
         * out.print(realPath + "<br/>");
         */
        String realPath = application.getRealPath("/index.html");
        out.print(realPath + "<br/>");  // C:\Users\Running Noob\Code Project\javaweb\out\artifacts\servlet04_war_exploded\index.html
        /**
         * 3.`public void log(String message);` 记录日志信息。
         * 这些日志信息记录到哪里了？ -> %CATALINA_HOME%logs 目录下
         * // 注意：IDEA工具的Tomcat服务器是根据下载的Tomcat服务器生成的副本
         * // Tomcat服务器的logs目录下都有哪些日志文件？
         * //catalina.2021-11-05.log 服务器端的java程序运行的控制台信息。
         * //localhost.2021-11-05.log ServletContext对象的log方法记录的日志信息存储到这个文件中。
         * //localhost_access_log.2021-11-05.txt 访问日志。
         */
        application.log("hello,world!");
        /**
         * 4.`public void log(String message, Throwable t);`
         *  除了记录日志信息外，还记录异常信息，控制台不会发送异常，只是记录异常信息。
         */
        int age = 1;
        if (age < 18) {
            application.log("年龄未满18岁", new RuntimeException("age < 18"));
        }
    }
}