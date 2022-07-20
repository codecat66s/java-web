package com.itheima.web;

import com.itheima.poij.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletUpdateBrand")
public class ServletUpdateBrand extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //解决post请求中文乱码问题
        /*接收post请求参数*/
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        /*将数据更新到数据库*/
        brandService.updateById(new Brand(id, name, description, status));
        /*请求转发到显示所有界面*/
        request.getRequestDispatcher("/ServletSelectAll").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
