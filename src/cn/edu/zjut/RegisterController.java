package cn.edu.zjut;

import cn.edu.zjut.dao.UserDao;
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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setType("user");
        UserDao dao = new UserDao();
        String regMsg;
        if (dao.exist(user)) {
            regMsg = "该用户名已被注册。";
            request.setAttribute("regMsg", regMsg);
            request.getRequestDispatcher("/register.jsp")
                    .forward(request, response);
        } else {
            boolean success = dao.insert(user);
            if (success) {
                regMsg = "用户注册成功！";
                request.setAttribute("regMsg", regMsg);
                request.getRequestDispatcher("/regSuccess.jsp")
                        .forward(request, response);
            } else {
                regMsg = "用户注册失败！";
                request.setAttribute("regMsg", regMsg);
                request.getRequestDispatcher("/register.jsp")
                        .forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
