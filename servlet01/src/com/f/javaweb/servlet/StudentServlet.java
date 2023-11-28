package com.f.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @author fzy
 * @date 2023/10/24 17:55
 */
public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        //设置相应内容的类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //连接数据库(JDBC)
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/javaweb?useSSL=false";
            String user = "root";
            String pwd = "******";  //根据实际情况填写
            conn = DriverManager.getConnection(url, user, pwd);
            //获取预编译的数据库操作对象
            String sql = "SELECT number, name FROM student";
            ps = conn.prepareStatement(sql);
            //执行SQL
            result = ps.executeQuery();
            //处理结果集
            while (result.next()) {
                String number = result.getString("number");
                String name = result.getString("name");
                out.print(number + " - " + name + "<br/>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //释放资源
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
