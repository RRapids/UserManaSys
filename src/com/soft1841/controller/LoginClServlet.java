package com.soft1841.controller;

import com.soft1841.model.User;
import com.soft1841.model.UserDaoSQLServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "LoginClServlet", urlPatterns = "/LoginClServlet")
public class LoginClServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession hs = request.getSession(true);
        //接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDaoSQLServerImpl userdao = new UserDaoSQLServerImpl();
        List<HashMap> lists = new ArrayList<>();
        if (userdao.findUser(user)) {
            lists = userdao.search(0, 3);
            int pageCount = userdao.searchCount();
            //要把lists中数据带入Welcome页面中
            request.setAttribute("查询结果",lists);
            request.setAttribute("pageCount",pageCount);
            request.setAttribute("pageNow","1");
            System.out.println(username + password);
            hs.setAttribute("username", username);
//              response.sendRedirect("Welcome?username="+username+"&password="+password);
            request.getRequestDispatcher("Welcome.jsp").forward(request, response);

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
