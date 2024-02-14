<%@ page import="openGauss.music.Bean.Song" %>
<%@ page import="openGauss.music.util.MusicSystem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>当前播放</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/currentmusic.css">
</head>

<body>
<jsp:include page="head.jsp"/>
<div class="content ban">
    <%
        Song song = MusicSystem.GetInstance().GetSong();
        if(song == null)
        {
            song = new Song("none", "当前未播放歌曲","none", "none", "none","none");
        }
    %>
    <h3 class="music-name"><%=song.GetSongName()%></h3>
    <div class="album-art">
        <a><img src="<%=request.getContextPath()%>/music/imgs/album/<%=song.GetAlbumID()%>.jpg" alt=""></a>
    </div>
    <div class="audio-wrap">
        <audio controls src="<%=request.getContextPath()%>/music/audio/<%=song.GetSongID()%>.ogg"></audio>
    </div>
</div>
</body>

</html>