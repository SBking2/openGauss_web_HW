<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page import="openGauss.music.Bean.Song" %>
    <%@ page import="java.util.List" %>
      <%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false"%>
        <!doctype html>
        <html lang="en">

        <head>
          <meta charset="UTF-8">
          <title>筛选歌曲</title>
          <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
          <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/select.css">
          <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/musiclist.css">
        </head>

        <body>
          <jsp:include page="head.jsp" />
          <div class="ban">
            <%
              String message = (String) request.getAttribute("message");
              if(message == null)
              {
                message = "无";
              }
            %>
            <h3>筛选条件：${message}</h3>
            <form action="<%=request.getContextPath()%>/SelectServlet?signal=select" method="post">
            <ul class="select-list">
                <li>
                  <b>语言</b>
                  <span><label>中文 <input type="checkbox" name="chinese"></label></span>
                  <span><label>日文 <input type="checkbox" name="japan"></label></span>
                  <span><label>英文 <input type="checkbox" name="english"></label></span>
                </li>
                <li>
                  <b>风格</b>
                  <span><label>放松 <input type="checkbox" name="relax"></label></span>
                  <span><label>摇滚 <input type="checkbox" name="rock"></label></span>
                  <span><label>说唱 <input type="checkbox" name="rap"></label></span>
                  <span><label>流行 <input type="checkbox" name="pop"></label></span>
                  <span><label>纯音乐 <input type="checkbox" name="music"></label></span>
                  <span><label>典雅 <input type="checkbox" name="piano"></label></span>
                </li>
                <li class="btn">
                  <input type="submit" value="筛选">
                  <input type="reset">
                </li>
            </ul>
            </form>


            <h3>筛选结果：</h3>

            <ul class="music-list">
              <li>
                <a>歌曲名</a><a>歌手</a><a>风格</a><a>所属专辑</a>
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
                <a href="<%=request.getContextPath()%>/MusicServlet?MusicSongID=<%=song.GetSongID()%>"><%=song.GetSongName()%></a>
                <a href="<%=request.getContextPath()%>/SingerServlet?SingerID=<%=song.GetSingerID()%>&SingerName=<%=song.GetSingerName()%>"><%=song.GetSingerName()%></a>
                <a><%=song.GetSongLa()%>,<%=song.GetSongSt()%></a>
                <a href="<%=request.getContextPath()%>/AlbumServlet?AlbumID=<%=song.GetAlbumID()%>&AlbumName=<%=song.GetAlbumName()%>"><%=song.GetAlbumName()%></a>
              </li>
              <%
                }
              %>
              </li>
            </ul>
          </div>
        </body>

        </html>