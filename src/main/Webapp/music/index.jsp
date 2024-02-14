<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="openGauss.music.Bean.Song" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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

    <%
        List<Song> songList = (List<Song>) request.getAttribute("songList");
        if(songList == null) {
            songList = new ArrayList<>();
        }
        for(Song song: songList){
    %>
    <li class="song">
        <div class="img">
            <a href="<%=request.getContextPath()%>/MusicServlet?MusicSongID=<%=song.GetSongID()%>">
            <img src="<%=request.getContextPath()%>/music/imgs/album/<%=song.GetAlbumID()%>.jpg" alt="">
            </a>
        </div>
        <span class="song-name"><%=song.GetSongName()%></span>
        <span class="song-singer"><%=song.GetSingerName()%></span>
    </li>

    <%
        }
    %>


</ul>
</body>

</html>