import DAO.UserDao;
import JBean.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户提交的登录信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用UserDao验证用户信息
        UserDao userDao = new UserDao();
        try {
            // 在实际应用中，可能需要添加更复杂的身份验证逻辑
            if (userDao.authenticateUser(username, password)) {
                // 验证成功，创建用户会话并将用户信息存储在session中
                User user = userDao.getUserByUsername(username);
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);

                // 登录成功后重定向到成绩显示页面
                response.sendRedirect("grades.jsp");
            } else {
                // 验证失败，重定向到登录页面
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 在实际应用中，可能需要采取适当的措施来处理数据库操作异常
        } finally {
            userDao.closeConnection(); // 释放数据库连接
        }
    }
}
