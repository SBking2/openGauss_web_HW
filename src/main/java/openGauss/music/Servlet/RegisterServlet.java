package openGauss.music.Servlet;

import openGauss.music.Bean.User;
import openGauss.music.Service.UserService;
import openGauss.music.util.MusicSystem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String userName = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        User user = new User(userName, userpwd);
        String result = UserService.RegisterUser(user);
        System.out.println(result);
        if(result != null && result.equals("succeed"))
        {
            //注册成功
            MusicSystem.GetInstance().SetUser(user);
            request.getRequestDispatcher("/IndexServlet").forward(request, response);
        }else
        {
            //注册失败
            request.setAttribute("message", result);
            request.getRequestDispatcher("/music/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
