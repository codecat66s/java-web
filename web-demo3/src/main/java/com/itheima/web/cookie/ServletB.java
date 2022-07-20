package com.itheima.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(urlPatterns = "/ServletB")
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = URLDecoder.decode(cookie.getValue(),"UTF-8");
            if ("userName".equals(name)) {
                System.out.println("userName："+value);
                break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
