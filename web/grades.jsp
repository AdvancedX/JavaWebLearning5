<%@ page import="JBean.Grade" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<!-- grades.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Grades Display</title>
</head>
<body>
<h2>Grades Display</h2>

<%-- Check if user is logged in --%>
<% if (session.getAttribute("user") != null) { %>
<%-- User is logged in, display grades --%>
<%-- Call a method to get grades from the database --%>
<%-- Display grades in a table --%>
<table border="1">
    <thead>
    <tr>
        <th>Subject</th>
        <th>Score</th>
    </tr>
    </thead>
</table>
<% } else { %>
<%-- User is not logged in, display a message or redirect to login page --%>
<p>Please log in to view grades.</p>
<% } %>
</body>
</html>
