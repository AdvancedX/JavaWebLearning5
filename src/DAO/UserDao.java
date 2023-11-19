package DAO;// DAO.UserDao.java
import JBean.User;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao() {
        // 在构造函数中建立数据库连接
        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            String url = "jdbc:mysql://localhost:3306/stu_manage";
            String username = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // 在实际应用中，应该处理连接失败的情况，可能需要抛出异常或采取其他措施。
        }
    }


    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, gender, password, major, class, student_id, introduction) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMajor());
            preparedStatement.setString(5, user.getClazz());
            preparedStatement.setString(6, user.getStudentId());
            preparedStatement.setString(7, user.getIntroduction());

            preparedStatement.executeUpdate();
        }
    }

    public User getUserById(int userId) throws SQLException {
        User user = null;
        String query = "SELECT * FROM user WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    String password = resultSet.getString("password");
                    String major = resultSet.getString("major");
                    String clazz = resultSet.getString("class");
                    String studentId = resultSet.getString("student_id");
                    String introduction = resultSet.getString("introduction");

                    user = new User(userId, name, gender, password, major, clazz, studentId, introduction);
                }
            }
        }

        return user;
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE name = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Returns true if a record is found, indicating successful authentication
            }
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        User user = null;
        String query = "SELECT * FROM user WHERE name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    String password = resultSet.getString("password");
                    String major = resultSet.getString("major");
                    String clazz = resultSet.getString("class");
                    String studentId = resultSet.getString("student_id");
                    String introduction = resultSet.getString("introduction");

                    user = new User(id, name, gender, password, major, clazz, studentId, introduction);
                }
            }
        }

        return user;
    }
}
