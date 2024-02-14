package openGauss.music.Servlet;

import openGauss.music.Bean.Song;
import openGauss.music.Service.MusicService;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SelectServlet", value = "/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String signal = request.getParameter("signal");
        List<Song> songList;
        if(signal != null && signal.equals("select"))
        {
            List<String> language = new ArrayList<String>();
            List<String> style = new ArrayList<String>();
            String languageCon[] = {"chinese", "japan", "english"};
            String styleCon[] = {"relax", "rock", "rap", "pop", "music", "piano"};
            String languageCCon[] = {"中文", "日本", "英文"};
            String styleCCon[] = {"放松", "摇滚", "说唱", "流行", "纯音乐", "典雅"};
            String condition = "";
            int i = 0;
            for(i=0; i< 3 ;i++)
            {
                String temp = request.getParameter(languageCon[i]);
                if(temp!=null)
                {
                    language.add(languageCCon[i]);
                    condition = condition + languageCCon[i] +" ";
                }
            }
            for(i=0; i< 6 ;i++)
            {
                String temp = request.getParameter(styleCon[i]);
                if(temp!=null)
                {
                    style.add(styleCCon[i]);
                    condition = condition + styleCCon[i] +" ";
                }
            }
            songList = MusicService.GetSelectedSong(language, style);
            System.out.println(songList);
            request.setAttribute("message", condition);
            request.setAttribute("songList", songList);
            //获取字符数组
        }else
        {
            songList = MusicService.GetAllSong();
            request.setAttribute("songList", songList);
        }
        request.getRequestDispatcher("/music/select.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
