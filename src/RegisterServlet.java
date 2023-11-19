import DAO.UserDao;
import JBean.User;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取用户提交的表单数据
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String major = request.getParameter("major");
        String clazz = request.getParameter("clazz");
        String studentId = request.getParameter("studentId");
        String introduction = request.getParameter("introduction");

        // 创建User对象
        User user = new User(0, name, gender, password, major, clazz, studentId, introduction);

        // 调用UserDao将用户信息存储到数据库
        UserDao userDao = new UserDao();
        try {
            userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            // 在实际应用中，可能需要采取适当的措施来处理数据库操作异常
        } finally {
            userDao.closeConnection(); // 释放数据库连接
        }

        // 注册成功后重定向到登录页面
        response.sendRedirect("index.jsp");
    }
}
