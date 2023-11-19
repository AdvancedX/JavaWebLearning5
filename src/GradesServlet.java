import DAO.GradeDao;
import JBean.Grade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GradesServlet")
public class GradesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 检查用户是否已登录
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            // 用户已登录，从数据库获取成绩信息
            try {
                List<Grade> grades = getGradesFromDatabase();

                // 将成绩信息存储在请求的属性中
                request.setAttribute("grades", grades);

                // 转发到成绩显示页面
                request.getRequestDispatcher("grades.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                // 在实际应用中，可能需要采取适当的措施来处理数据库操作异常
            }
        } else {
            // 用户未登录，重定向到登录页面
            response.sendRedirect("login.jsp");
        }
    }

    // 从数据库获取成绩信息的示例方法
    public List<Grade> getGradesFromDatabase() throws SQLException {
        GradeDao gradeDao = new GradeDao();
        return gradeDao.getAllGrades();
    }
}

