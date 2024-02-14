package openGauss.music.Servlet;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SingerServlet", value = "/SingerServlet")
public class SingerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String singerID = request.getParameter("SingerID");
        String singerName = request.getParameter("SingerName");
        List<Song> songList= MusicService.GetSingerSongs(singerID);
        request.setAttribute("songList", songList);
        request.setAttribute("SingerName", singerName);
        request.setAttribute("SingerID", singerID);

        request.getRequestDispatcher("/music/singer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
