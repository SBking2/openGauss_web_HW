package openGauss.music.Servlet;

import openGauss.music.Service.MusicService;
import openGauss.music.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet", value = "/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String delete = request.getParameter("Delete");
        if(delete!=null && delete.equals("delete"))
        {
            String passwd = request.getParameter("userpasswd");
            if(UserService.DeleteUser(passwd))
            {
                request.getRequestDispatcher("/loginServlet").forward(request,response);
            }else {
                String message = "密码错误!";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/music/deleteuser.jsp").forward(request, response);
            }
        }else
        {
            request.getRequestDispatcher("/music/deleteuser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.doGet(request, response);
    }
}
