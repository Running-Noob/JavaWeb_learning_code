package com.f.javaweb.adapter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/11/11 14:36
 */

/**
 * 编写一个标准通用的Servlet，起名：GenericServlet
 * 以后所有的Servlet类都不要直接实现Servlet接口了。
 * 以后所有的Servlet类都要继承GenericServlet类。
 * GenericServlet 就是一个适配器。
 */
public abstract class GenericServlet implements Servlet {
    //创建一个私有的 `ServletConfig` 成员变量, 在 `init` 方法中给其赋值
    private ServletConfig servletConfig;

    //防止子类重写已经写好的 `init` 方法
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        this.init();    //在该方法中调用允许子类重写的 `init` 方法
    }

    //提供一个单独的 `init` 方法供子类重写
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    /**
     * 抽象方法，这个方法最常用。所以要求子类必须实现service方法。
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
