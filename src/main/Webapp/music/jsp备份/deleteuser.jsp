<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="cn">
<head>
  <meta charset="UTF-8">
  <title>注销账号</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/login.css">
</head>

<body>
<jsp:include page="head.jsp"/>

<h3>注销账号</h3>
<div class="log-infor">
  <%
    String message = (String) request.getAttribute("message");
    if(message != null){
  %>
  <h3 style="color: red">${message}</h3>
  <%
    }
  %>
  <form action="<%=request.getContextPath()%>/DeleteUserServlet?Delete=delete" method="post">
    <label>
      用户密码：
    <input type="password" name="userpasswd" id="userpasswd"><br>
    </label>
    <input type="submit" value="注销">

  </form>
</div>

</body>

</html>