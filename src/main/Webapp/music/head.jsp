<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
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
        <li class="center"><a href="<%=request.getContextPath()%>/IndexServlet">首页</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/MusicServlet">当前播放</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/MusiclistServlet">歌曲列表</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/SelectServlet">歌曲筛选</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/AlbumlistServlet">专辑列表</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/SingerlistServlet">歌手列表</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/UserServlet">我的</a></li>
        <li class="center"><a href="<%=request.getContextPath()%>/ManagerListServlet">后台管理</a></li>
        <li class="search">
            <form action="<%=request.getContextPath()%>/SearchServlet" class="ser-form">
                <input type="text" class="tex" placeholder="请输入想搜索的歌曲" name="searchsong" id="searchsong">
                <input type="submit" class="btn" value="搜索">
            </form>
        </li>
    </ul>
</div>
</body>
</html>
