package cn.edu.zjut;

import cn.edu.zjut.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a on 2017/10/10.
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        if (checkUser(user)) {
            request.setAttribute("USER", user);
            request.getRequestDispatcher("/loginSuccess.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/javaweb-prj1/loginFailed.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean checkUser(UserBean user) {
        return "zjut".equals(user.getUsername())
                && "zjut".equals(user.getPassword())
                && "admin".equals(user.getType());
    }
}
