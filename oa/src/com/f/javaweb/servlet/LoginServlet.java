package com.f.javaweb.servlet;

import com.f.javaweb.utils.JDBCUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author fzy
 * @date 2023/12/7 15:42
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean success = false;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT `username` FROM t_user WHERE `username` = ? AND `pwd` = MD5(?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            if (rs.next()) {
                success = true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, ps, rs);
        }

        if (success) {
            // 如果登录成功，就得到session对象，如果session对象不存在，就创建
            // 无论如何，都要得到一个session对象
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect(request.getContextPath()+"/jump");
        } else {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
