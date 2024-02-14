package openGauss.music.Servlet;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AlbumServlet", value = "/AlbumServlet")
public class AlbumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String albumID = request.getParameter("AlbumID");
        String albumName = request.getParameter("AlbumName");
        List<Song> songList= MusicService.GetSongs(albumID);


        request.setAttribute("songList", songList);
        request.setAttribute("AlbumName", albumName);
        request.setAttribute("AlbumID", albumID);
        request.getRequestDispatcher("/music/album.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request,response);
    }
}
