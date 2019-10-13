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

@WebServlet(name = "ServletContextTest2",urlPatterns = {"/ServletContextTest2"})
public class ServletContextTest2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //1.取实例
        ServletContext sc = this.getServletContext();
        //2.赋值
        String info= (String) sc.getAttribute("myInfo");
        //3.输出
        out.println("ServletContext:"+info);
        //生成对象
        HttpSession hs= request.getSession(true);
        //取值
        String myName= (String) hs.getAttribute("myName");
        //3.输出
        out.println("Session:"+myName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
