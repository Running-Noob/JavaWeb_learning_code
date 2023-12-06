package com.f.javaweb.annotation;

import jakarta.servlet.annotation.WebServlet;

/**
 * @author fzy
 * @date 2023/12/6 13:20
 */
public class TestWelcomeServletAnnotation {
    public static void main(String[] args) throws Exception {
        // 获取WelcomeServlet类对象
        Class welcomeServletClass = Class.forName("com.f.javaweb.servlet.WelcomeServlet");
        // 判断该类中是否有WebServlet注解
        if (welcomeServletClass.isAnnotationPresent(WebServlet.class)) {
            // 获取这个类上面的WebServlet注解
            WebServlet webServletAnnotation = (WebServlet) welcomeServletClass.getAnnotation(WebServlet.class);
            // 获取注解的value属性值
            String[] values = webServletAnnotation.value();
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}
