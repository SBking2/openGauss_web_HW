<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="openGauss.music.Bean.Song" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>专辑详情</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/album.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/musiclist.css">
</head>

<body>
<jsp:include page="head.jsp"/>
<div class="w700">
    <%
        List<Song> songList = (List<Song>) request.getAttribute("songList");
        String singerName = (String) request.getAttribute("SingerName");
        String singerID = (String) request.getAttribute("SingerID");
        if(songList == null)
        {
            songList = new ArrayList<Song>();
        }
    %>
    <h3 class="album-name"><%=singerName%></h3>
    <div class="album-con">

        <div class="album-art">
            <img src="<%=request.getContextPath()%>/music/imgs/singer/<%=singerID%>.jpg" alt="">
        </div>

    </div>
    <ul style="margin-bottom: 50px;" class="music-list">

        <%
            for(Song song: songList){
        %>
        <li>
            <a href = "<%=request.getContextPath()%>/MusicServlet?MusicSongID=<%=song.GetSongID()%>">
                <%=song.GetSongName()%>
            </a>
        </li>
        <%
            }
        %>

    </ul>

</div>
</body>

</html>