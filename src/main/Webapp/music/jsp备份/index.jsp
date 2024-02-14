<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024/1/13
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/index.css">
</head>

<body>
<jsp:include page="head.jsp"/>
<ul class="commend ban">
    <li class="song">
        <div class="img">
            <img src="imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
    <li class="song">
        <div class="img">
            <img src="<%=request.getContextPath()%>/music/imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
    <li class="song">
        <div class="img">
            <img src="<%=request.getContextPath()%>/music/imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
    <li class="song">
        <div class="img">
            <img src="<%=request.getContextPath()%>/music/imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
    <li class="song">
        <div class="img">
            <img src="imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
    <li class="song">
        <div class="img">
            <img src="imgs/a1.jpg" alt="">
            <div class="mask">添加到播放列表</div>
        </div>
        <span class="song-name">歌名</span>
        <span class="song-singer">歌手</span>
    </li>
</ul>
</body>

</html>