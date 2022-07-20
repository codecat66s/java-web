package com.itheima.web;

import com.itheima.poij.Brand;
import com.itheima.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletAddBrand")
public class ServletAddBrand extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); //处理中文乱码问题
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        Brand brand = new Brand(null, name, description, status);
        /*更新数据到数据库*/
        brandService.addBrand(brand);
        /*重定向到查询所有界面*/
        response.sendRedirect("/ServletSelectAll");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
