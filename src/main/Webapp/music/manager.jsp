<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ page isELIgnored="false" %>
    <html>

    <head>
      <title>Manage</title>
      <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/musiclist.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/manage.css">
    </head>

    <body>
      <jsp:include page="managerHead.jsp" />
      <div class="w700">
        <div class="log-infor">
          <% String message=(String) request.getAttribute("message"); if(message !=null){ %>
            <h3 style="color: red">${message}</h3>
            <% } %>

              <form action="<%=request.getContextPath()%>/UpdateServlet?type=addSong" method="post">
                <label>
                  <input type="text" name="SongID" id="AddSongID" placeholder="歌曲ID">
                  <input type="text" name="SongName" id="AddSongName" placeholder="歌曲名字">
                  <input type="text" name="AlbumID" id="AddSongAlbumID" placeholder="专辑ID">
                  <input type="submit" value="添加歌曲">
                </label>
              </form>
              <form action="<%=request.getContextPath()%>/UpdateServlet?type=addAlbum" method="post">
                <label>
                  <input type="text" name="AlbumID" id="AddAlbumID" placeholder="专辑ID">
                  <input type="text" name="AlbumName" id="AddAlbumName" placeholder="专辑名字">
                  <input type="text" name="SingerID" id="AddAlbumSingerID" placeholder="歌手ID">
                  <input type="submit" value="添加专辑">
                </label>
              </form>
              <form action="<%=request.getContextPath()%>/UpdateServlet?type=addSinger" method="post">
                <label>
                  <input type="text" name="SingerID" id="AddSingerID" placeholder="歌手ID">
                  <input type="text" name="SingerName" id="AddSingerName" placeholder="歌手名字">
                  <input type="submit" value="添加歌手">
                </label>
              </form>
              <form action="<%=request.getContextPath()%>/UpdateServlet?type=deleteSong" method="post">
                <label>
                  <input type="text" name="SongID" id="DeleteSongID" placeholder="歌曲ID">
                  <input type="submit" value="删除歌曲">
                </label>
              </form>
              <form action="<%=request.getContextPath()%>/UpdateServlet?type=deleteAlbum" method="post">
                <label>
                  <input type="text" name="AlbumID" id="DeleteAlbumID" placeholder="专辑ID">
                  <input type="submit" value="删除专辑">
                </label>
              </form>
              <form action="<%=request.getContextPath()%>/UpdateServlet?type=deleteSinger" method="post">
                <label>
                  <input type="text" name="SingerID" id="DeleteSingerID" placeholder="歌手ID">
                  <input type="submit" value="删除歌手">
                </label>
              </form>
        </div>
      </div>
    </body>

    </html>