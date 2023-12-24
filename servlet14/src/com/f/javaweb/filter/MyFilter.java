package com.f.javaweb.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author fzy
 * @date 2023/12/23 13:28
 */
//@WebFilter({"/a.get", "/b.get"})  // 精确匹配
/*以下这个路径属于模糊匹配中的扩展匹配。以"*"开始, 注意这种路径不要以"/"开始*/
//@WebFilter("*.get")
//@WebFilter("/dept/*") // 属于前缀匹配
//@WebFilter("/*")  // 匹配所有路径
public class MyFilter implements Filter {
    public MyFilter() {
        System.out.println("无参构造方法执行...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 在请求的时候添加过滤规则
        System.out.println("doFilter方法开始执行...");
        // 执行下一个过滤器, 如果下一个不是过滤器了, 则执行目标程序Servlet
        chain.doFilter(request, response);
        // 在响应的时候添加过滤规则
        System.out.println("doFilter方法执行结束...");
    }
}