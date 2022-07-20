package com.itheima.web;

import com.itheima.poij.User;
import com.itheima.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletUserLogin")
public class ServletUserLogin extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //解决post中文乱码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");



        //登录逻辑
        User userLogin = userService.login(new User(userName, password));
        if (userLogin != null) {
            /*登录成功*/
            //保存用户名到session
            HttpSession session = request.getSession();
            session.setAttribute("userName", userName);

            //response重定向
            response.sendRedirect("/ServletSelectAll");

        } else {
            //登录失败
            request.setAttribute("login_msg", "false"); //请求转发
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
