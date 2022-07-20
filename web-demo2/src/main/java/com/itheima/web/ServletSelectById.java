package com.itheima.web;

import com.itheima.poij.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/ServletSelectById")
public class ServletSelectById extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        /*查询Brand*/
        Brand brand = brandService.selectByID(id);
        /*请求转发，以便显示数据*/
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
