package cn.edu.zjut.controller;

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
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        //使用UserBean对象存储数据
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        //业务逻辑
        if (checkUser(user)) {
            //将用户对象保持到request域中
            request.setAttribute("USER", user);
            //请求转发到登录成功页面
            request.getRequestDispatcher("/loginSuccess.jsp")
                    .forward(request, response);
        } else {
            //重定向到登录失败页面
            response.sendRedirect("/javaweb-prj1/loginFailed.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean checkUser(UserBean user) {
        UserDao dao = new UserDao();
        //判断用户数据是否匹配
        return dao.searchUser(user);
    }
}