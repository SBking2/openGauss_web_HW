package openGauss.music.Servlet;

import openGauss.music.Bean.User;
import openGauss.music.Service.UserService;
import openGauss.music.util.MusicSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet",urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取请求方的参数，查看是否是从login页面传来的请求
        String type = request.getParameter("type");

        //若是登录请求，则做登录逻辑，若不是，则跳转到登录界面
        if("login".equals(type))
        {
            String userName = request.getParameter("userName");
            String userPassword = request.getParameter("userPassword");
            if(userName == null ||"".equals(userName.trim())|| userPassword == null||"".equals(userPassword.trim()))
            {
                request.setAttribute("message", "用户名或密码不能为空!");
                request.getRequestDispatcher("/music/login.jsp").forward(request, response);
                return;
            }
            User user = new User(userName, userPassword);
            if(UserService.CheckLogin(user))
            {
                System.out.println("login success!");
                //登录成功！跳转到主页面
                //音乐系统初始化
                MusicSystem.GetInstance();
                MusicSystem.GetInstance().SetUser(user);
                request.getRequestDispatcher("/IndexServlet").forward(request, response);
            }else
            {
                request.setAttribute("message", "用户名或密码不正确!");
                System.out.println("login failed!");
                request.getRequestDispatcher("/music/login.jsp").forward(request,response);
            }

        }else
        {
            request.getRequestDispatcher("/music/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }

}
