package openGauss.music.Servlet;

import openGauss.music.Service.UserService;
import openGauss.music.util.MusicSystem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String change = request.getParameter("UserChange");
        if(change == null)
        {
            //不是修改用户是访问
        }else
        {
            //修改用户
            if(change.equals("pwd"))
            {
                String newPwd = request.getParameter("userpwd");
                UserService.SetUserPassword(newPwd);
                MusicSystem.GetInstance().GetUser().SetPassword(newPwd);
                request.setAttribute("message", "succeed");
            }else if(change.equals("name"))
            {
                String newName = request.getParameter("username");
                String result = UserService.SetUserName(newName);
                if(result.equals("succeed"))
                {
                    MusicSystem.GetInstance().GetUser().SetName(newName);
                }
                request.setAttribute("message", result);
            }
            request.getRequestDispatcher("/music/mymusic.jsp").forward(request, response);
        }

        //跳转到User页面
        request.getRequestDispatcher("/music/mymusic.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
