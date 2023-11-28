package com.f.javaweb.adapter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/11/11 14:44
 */
public class StudentService extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        //调用父类的 getServletConfig 方法得到 ServletConfig 对象
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println("ServletConfig：" + servletConfig);
        System.out.println("Student service method execute!");
    }

    @Override
    public void init() {
        System.out.println("Student service init method execute!");
    }
}
