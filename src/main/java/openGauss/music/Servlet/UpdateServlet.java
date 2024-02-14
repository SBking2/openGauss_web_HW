package openGauss.music.Servlet;

import openGauss.music.Service.MusicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String type = request.getParameter("type");
        String message;
        if(type == null)
        {
            request.getRequestDispatcher("/music/manager.jsp").forward(request, response);
        }else
        {
            if("addSong".equals(type))
            {
                String SongID = request.getParameter("SongID");
                String SongName = request.getParameter("SongName");
                String AlbumID = request.getParameter("AlbumID");
                String result = MusicService.AddSong(SongID, SongName, AlbumID);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }else if("deleteSong".equals(type))
            {
                String SongID = request.getParameter("SongID");
                String result = MusicService.DeleteSong(SongID);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }else if("addSinger".equals(type))
            {
                String SingerID = request.getParameter("SingerID");
                String SingerName = request.getParameter("SingerName");
                String result = MusicService.AddSinger(SingerID, SingerName);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }else if("deleteSinger".equals(type))
            {
                String singerID = request.getParameter("SingerID");
                String result = MusicService.DeleteSinger(singerID);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }else if("addAlbum".equals(type))
            {
                String AlbumID = request.getParameter("AlbumID");
                String AlbumName = request.getParameter("AlbumName");
                String SingerID = request.getParameter("SingerID");
                String result = MusicService.AddAlbum(AlbumID, AlbumName, SingerID);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }else if("deleteAlbum".equals(type))
            {
                String albumID = request.getParameter("AlbumID");
                String result = MusicService.DeleteAlbum(albumID);
                request.setAttribute("message", result);
                request.getRequestDispatcher("/music/manager.jsp").forward(request, response);

            }
        }
        request.getRequestDispatcher("/music/manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
