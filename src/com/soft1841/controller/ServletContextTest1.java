package com.soft1841.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletContextTest1",urlPatterns =  {"/ServletContextTest1"})
public class ServletContextTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //1.取实例
        ServletContext sc = this.getServletContext();
        //2.赋值
        sc.setAttribute("myInfo","yuan");
        //1 session实例
        HttpSession hs = request.getSession(true);
        //2.赋值
        hs.setAttribute("myName","yuan");
        out.println("赋值OK");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
