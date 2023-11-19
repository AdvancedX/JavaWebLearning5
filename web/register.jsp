<%--
  Created by IntelliJ IDEA.
  JBean.User: 15640
  Date: 2023/11/13
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- register.jsp -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JBean.User Registration</title>
</head>
<body>
<h2>JBean.User Registration</h2>
<form action="RegisterServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender" required>
        <option value="male">Male</option>
        <option value="female">Female</option>
    </select><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <label for="major">Major:</label>
    <input type="text" id="major" name="major" required><br>

    <label for="clazz">Class:</label>
    <input type="text" id="clazz" name="clazz" required><br>

    <label for="studentId">Student ID:</label>
    <input type="text" id="studentId" name="studentId" required><br>

    <label for="introduction">Introduction:</label>
    <textarea id="introduction" name="introduction" rows="4" cols="50" required></textarea><br>

    <input type="submit" value="Register">
</form>
</body>
</html>

