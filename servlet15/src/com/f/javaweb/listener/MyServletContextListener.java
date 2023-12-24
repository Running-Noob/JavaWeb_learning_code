package com.f.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * @author fzy
 * @date 2023/12/23 15:47
 */
// ServletContextListener监听器主要监听的是ServletContext对象的状态
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 这个方法在ServletContext对象被创建的时候调用, 由web服务器自动调用。
        System.out.println("ServletContext对象创建了...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 这个方法在ServletContext对象被销毁的时候调用, 由web服务器自动调用。
        System.out.println("ServletContext对象销毁了...");
    }
}
