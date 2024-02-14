<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="head">
    <ul>
        <li class="first">
            <a href="###">
                <span class="logo"></span>
                <span class="logoo"></span>
                <span class="logo logo-b"></span>
                后台管理
            </a>
        </li>
        <li class="center"><a href="<%=request.getContextPath()%>/music/index.jsp">首页</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/ManagerListServlet?type=song">歌曲数据</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/ManagerListServlet?type=album">专辑数据</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/ManagerListServlet?type=singer">歌手数据</a></li>
    </ul>
</div>
</body>
</html>
