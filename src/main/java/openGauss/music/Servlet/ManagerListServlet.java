package openGauss.music.Servlet;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerListServlet", value = "/ManagerListServlet")
public class ManagerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String type = request.getParameter("type");
        if(type == null)
        {

        }else
        {
            if(type.equals("song"))
            {
                List<Song> songList = MusicService.GetSongData();
                request.setAttribute("songList", songList);
                request.getRequestDispatcher("/music/adminsong.jsp").forward(request, response);
            }else if(type.equals("album"))
            {
                List<Song> songList = MusicService.GetAlbumData();
                request.setAttribute("songList", songList);
                request.getRequestDispatcher("/music/adminalbum.jsp").forward(request, response);
            }else if (type.equals("singer"))
            {
                List<Song> songList = MusicService.GetSingerData();
                request.setAttribute("songList", songList);
                request.getRequestDispatcher("/music/anminsinger.jsp").forward(request, response);
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
