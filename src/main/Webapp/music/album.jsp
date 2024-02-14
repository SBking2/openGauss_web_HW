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
        String albumName = (String) request.getAttribute("AlbumName");
        String albumID = (String) request.getAttribute("AlbumID");
        if(songList == null)
        {
            songList = new ArrayList<Song>();
        }
    %>
    <h3 class="album-name"><%=albumName%></h3>
    <div class="album-con">
        <div class="album-art">
            <img src="<%=request.getContextPath()%>/music/imgs/album/<%=albumID%>.jpg" alt="">
        </div>
    </div>
    <ul style="margin-bottom: 50px;" class="music-list">
        <li>
            <a href = "">
                歌曲名
            </a>
            <a href = "" >
               歌手
            </a>
        </li>

        <%
            for(Song song: songList){
        %>
        <li>
            <a href = "<%=request.getContextPath()%>/MusicServlet?MusicSongID=<%=song.GetSongID()%>">
                <%=song.GetSongName()%>
            </a>
            <a href = "<%=request.getContextPath()%>/SingerServlet?SingerID=<%=song.GetSingerID()%>&SingerName=<%=song.GetSingerName()%>" >
                <%=song.GetSingerName()%>
            </a>
        </li>
        <%
            }
        %>

    </ul>

</div>
</body>

</html>