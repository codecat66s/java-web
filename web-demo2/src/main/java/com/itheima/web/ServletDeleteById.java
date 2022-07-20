package com.itheima.web;

import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletDeleteById")
public class ServletDeleteById extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*接收get请求参数,因为是数字说以不需要处理中文乱码*/
        int id = Integer.parseInt(request.getParameter("id"));
        /*更新数据库*/
        brandService.deleteById(id);
        /*请求转到显示所有界面*/
        request.getRequestDispatcher("/ServletSelectAll").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
