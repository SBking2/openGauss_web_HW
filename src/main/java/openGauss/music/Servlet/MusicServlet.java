package openGauss.music.Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;
import openGauss.music.util.MusicSystem;

@WebServlet(name = "MusicServlet", value = "/MusicServlet")
public class MusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取穿来的歌曲名字
        String songID = request.getParameter("MusicSongID");
        //设置要传送给CM页面的数据
        Song song = MusicService.GetSong(songID);
        if(song!=null)
        {
            MusicSystem.GetInstance().SetSong(song);
        }
        request.getRequestDispatcher("/music/currentmusic.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
