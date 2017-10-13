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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //用UserBean对象存储数据
        UserBean user = new UserBean();
        user.setUsername(username);
        user.setPassword(password);
        user.setType("user");
        UserDao dao = new UserDao();
        String regMsg;
        if (dao.exist(user)) { //判断账号是否已经存在
            //账号存在的业务逻辑
            regMsg = "该用户名已被注册。";
            request.setAttribute("regMsg", regMsg);
            request.getRequestDispatcher("/register.jsp")
                    .forward(request, response);
        } else {
            //账号不存在的业务逻辑
            boolean success = dao.insert(user);
            if (success) {
                //插入用户数据成功的情况
                regMsg = "用户注册成功！";
                request.setAttribute("regMsg", regMsg);
                request.getRequestDispatcher("/regSuccess.jsp")
                        .forward(request, response);
            } else {
                //插入用户数据失败的情况
                regMsg = "用户注册失败！";
                request.setAttribute("regMsg", regMsg);
                request.getRequestDispatcher("/register.jsp")
                        .forward(request, response);
                //账号插入失败的可能是发生了SQLException
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
