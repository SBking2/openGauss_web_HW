<%@ page import="openGauss.music.Bean.Song" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>管理页面</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/music/css/admin.css">
</head>

<body>
<jsp:include page="managerHead.jsp"></jsp:include>
<div class="w700">
    <h3>
        专辑数据
    </h3>
    <table class="content" border="1">
        <thead>
        <tr>
            <th>专辑ID</th>
            <th>专辑名称</th>
        </tr>
        </thead>
        <%
            List<Song> songList = (List<Song>) request.getAttribute("songList");
            if(songList==null)
            {
                songList = new ArrayList<Song>();
            }
            for(Song song: songList){
        %>
        <tbody>
        <tr>
            <td><%=song.GetAlbumID()%></td>
            <td><%=song.GetAlbumName()%></td>
        </tr>
        </tbody>
        <%
            }
        %>

    </table>
</div>
</body>

</html>
