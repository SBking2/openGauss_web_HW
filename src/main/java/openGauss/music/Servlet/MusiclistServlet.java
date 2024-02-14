package openGauss.music.Servlet;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;

import javax.servlet.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MusiclistServlet", value = "/MusiclistServlet")
public class MusiclistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Song> songList = MusicService.GetAllSong();
        request.setAttribute("songList", songList);
        //跳转到歌曲列表页面
        request.getRequestDispatcher("/music/musiclist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
