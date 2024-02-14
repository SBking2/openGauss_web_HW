<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="cn">
<head>
  <meta charset="UTF-8">
  <title>请登录或注册</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/login.css">
</head>

<body>
<div class="head">
  <ul>
    <li class="first">
      <a href="###">
        <span class="logo"></span>
        <span class="logoo"></span>
        <span class="logo logo-b"></span>
        音乐
      </a>
    </li>
  </ul>
</div>

  <h3>请登录或注册</h3>
  <div class="log-infor">
    <%
      String message = (String) request.getAttribute("message");
      if(message != null){
    %>
    <h3 style="color: red">${message}</h3>
    <%
      }
    %>
    <form action="<%= request.getContextPath()%>/loginServlet?type=login" method="post">
      <label for="userName">
        用户账号：
      </label>
      <input type="text" name="userName" id="userName"><br>
      <label for="userPassword">
        用户密码：
      </label>
      <input type="password" name="userPassword" id="userPassword"><br>
      <input type="submit" value="登录">
    </form>
    <a href="<%=request.getContextPath()%>/music/register.jsp">注册</a>
  </div>

</body>

</html>