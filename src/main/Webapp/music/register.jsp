<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/login.css">
</head>

<body>
<jsp:include page="head.jsp"/>

<div class="w700">
    <h3>请注册</h3>
    <%
        String message = (String) request.getAttribute("message");
        if(message != null){
    %>
    <h3 style="color: red">${message}</h3>
    <%
        }
    %>
    <form class="log-infor" action="<%=request.getContextPath()%>/RegisterServlet" method="post">
        <label>用户名称：</label><input type="text" name="username" id="username"><br>
        <label>用户密码：</label><input type="password" name="userpwd" id="userpwd"><br>
        <input type="submit" value="注册">
    </form>

</div>
</body>

</html>