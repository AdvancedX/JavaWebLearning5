package DAO;

import JBean.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;


public class GradeDao {
    private Connection connection;

    public GradeDao() {
        // 在构造函数中建立数据库连接
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            String url = "jdbc:mysql://localhost:3306/stu_manage";
            String username = "root";
            String password = "123456";
            connection = getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 在实际应用中，应该处理连接失败的情况，可能需要抛出异常或采取其他措施。
        }
    }

    // 添加成绩
    public void addGrade(Grade grade) throws SQLException {
        String query = "INSERT INTO grades (user_id, subject, score) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getUserId());
            preparedStatement.setString(2, grade.getSubject());
            preparedStatement.setInt(3, grade.getScore());

            preparedStatement.executeUpdate();
        }
    }

    // 获取所有成绩
    public List<Grade> getAllGrades() throws SQLException {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM grades";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int userId = resultSet.getInt("user_id");
                    String subject = resultSet.getString("subject");
                    int score = resultSet.getInt("score");

                    grades.add(new Grade(id, userId, subject, score));
                }
            }
        }

        return grades;
    }
        public List<Grade> getGradeForUsers() throws SQLException {
            List<Grade> grades = new ArrayList<>();
            String query = "SELECT * FROM grades WHERE user_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int userId = resultSet.getInt("user_id");
                        String subject = resultSet.getString("subject");
                        int score = resultSet.getInt("score");

                        grades.add(new Grade(id, userId, subject, score));
                    }
                }
            }

            return grades;
        }


    // 释放数据库连接
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
