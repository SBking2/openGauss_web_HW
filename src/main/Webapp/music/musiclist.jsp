
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="openGauss.music.Bean.Song" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>播放列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/musiclist.css">

</head>

<body>
<jsp:include page="head.jsp"/>
<div class="ban">
    <h3>歌曲列表：</h3>
    <ul class="music-list">
        <li>
            <a href = "">歌曲名</a><a href = "" >歌手</a><a href = "" >所属专辑</a>
        </li>


        <%
          List<Song> songList = (List<Song>) request.getAttribute("songList");
          if(songList == null)
          {
              songList = new ArrayList<>();
          }
          for(Song song : songList){
        %>
        <li>
            <a href = "<%=request.getContextPath()%>/MusicServlet?MusicSongID=<%=song.GetSongID()%>">
                <%=song.GetSongName()%>
            </a>
            <a href = "<%=request.getContextPath()%>/SingerServlet?SingerID=<%=song.GetSingerID()%>&SingerName=<%=song.GetSingerName()%>" >
                <%=song.GetSingerName()%>
            </a>
            <a href = "<%=request.getContextPath()%>/AlbumServlet?AlbumID=<%=song.GetAlbumID()%>&AlbumName=<%=song.GetAlbumName()%>" >
                <%=song.GetAlbumName()%>
            </a>
        </li>
        <%
            }
        %>
    </ul>
</div>
</body>

</html>