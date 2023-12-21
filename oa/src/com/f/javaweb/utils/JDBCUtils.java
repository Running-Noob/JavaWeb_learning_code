package com.f.javaweb.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 * @author fzy
 * @date 2023/12/7 15:46
 */
public class JDBCUtils {
    private static ResourceBundle bundle = ResourceBundle.getBundle("com.f.javaweb.resources.db");
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String pwd = bundle.getString("password");

    static {
        try {
            // 注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pwd);
    }

    // 释放资源
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
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
