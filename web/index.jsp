<%--
  Created by IntelliJ IDEA.
  JBean.User: 15640
  Date: 2023/11/13
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- index.jsp -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JBean.User Login</title>
</head>
<body>
<h2>JBean.User Login</h2>
<form action="LoginServlet" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br>

    <input type="submit" value="Login">
    <br>
    <a href="register.jsp">Register</a>
</form>
</body>
</html>
