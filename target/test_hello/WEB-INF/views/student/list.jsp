<%@ page import="java.util.List" %>
<%@ page import="openGauss.connector.Bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% for (Student user : (List<Student>) request.getAttribute("students")) { %>
    <tr>
        <td><%= user.GetId() %></td>
        <td><%= user.GetName() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
