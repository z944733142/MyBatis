package com.Servlet;

import com.Service.impl.ServiceDemo;
import com.pojo.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/page")
public class Page extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNum = 1;
        String pageNum1 = req.getParameter("pageNum");
        if(pageNum1 != null && !pageNum1.equals(""))
        {
            pageNum = Integer.parseInt(pageNum1);
        }
        int pageSize = 4;
        String pageSize1 = req.getParameter("pageSize");
        if(pageSize1 != null && !pageSize1.equals(""))
        {
            pageSize = Integer.parseInt(pageSize1);
        }
        PageInfo pageInfo = new ServiceDemo().page(pageNum, pageSize);
        req.getSession().setAttribute("pageInfo", pageInfo);
        resp.sendRedirect("page.jsp");
    }
}
