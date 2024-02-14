<%@ page import="openGauss.music.util.MusicSystem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>我的</title>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/musiclist.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/mymusic.css">
</head>

<body>
<jsp:include page="head.jsp"/>
<div class="infor w700">
    <h3>个人信息</h3>
    <div class="infor-con">
        <%=MusicSystem.GetInstance().GetUser().GetName()%><span class="name"></span>
    </div>
    <form action="<%=request.getContextPath()%>/UserServlet?UserChange=name" class="change-con" method="post">
        <label>请输入新用户名：</label><input type="text" name="username" id="username">
        <input type="submit" value="确认">
    </form>
    <form action="<%=request.getContextPath()%>/UserServlet?UserChange=pwd" class="change-con" method="post">
        <label>请输入新密码：</label><input type="password" name="userpwd" id="userpwd">
        <input type="submit" value="确认">
    </form>
    <form action="<%=request.getContextPath()%>/loginServlet">
        <button>退出账号</button>
    </form>
    <form action="<%=request.getContextPath()%>/DeleteUserServlet">
        <button>注销账号</button>
    </form>
</div>

</body>

</html>
