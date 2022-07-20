package com.itheima.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(urlPatterns = "/ServletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*cookie不能直接存储中文数据，需要转码成其他编码格式的字符才行*/
        String value = "张三";
        String encodeValue = URLEncoder.encode(value, "UTF-8");
        System.out.println(encodeValue);

        Cookie cookie = new Cookie("userName", encodeValue);  //新建Cookie对象
        cookie.setMaxAge(60*60*24*7);  //设置存活时间一周
        response.addCookie(cookie);  //发送cookie到浏览器
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
