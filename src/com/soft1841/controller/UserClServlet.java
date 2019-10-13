package com.soft1841.controller;

import com.soft1841.model.User;
import com.soft1841.model.UserDaoSQLServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "UserClServlet", urlPatterns = {"/UserClServlet"})
public class UserClServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("flag");
        //分页
        if (flag.equals("fenye")) {
            List<HashMap> lists = new ArrayList<>();
            //取pageNow
            String s_pageNow = request.getParameter("pageNow");
            int pageNow = Integer.parseInt(s_pageNow);

            UserDaoSQLServerImpl userDaoSQLServer = new UserDaoSQLServerImpl();
            lists = userDaoSQLServer.search((pageNow - 1) * 3, 3);
            int pageCount = userDaoSQLServer.searchCount();
            request.setAttribute("result", lists);
            request.setAttribute("pageCount", pageCount + "");
            request.setAttribute("pageNow", pageNow + "");
            request.getRequestDispatcher("Welcome.jsp").forward(request, response);
        }
        //删除
        if (flag.equals("delUser")) {
            //取userId
            String s_userId = request.getParameter("userId");
            int userId = Integer.parseInt(s_userId);

            UserDaoSQLServerImpl userDaoSQLServer = new UserDaoSQLServerImpl();
            if (userDaoSQLServer.delete(userId) == 1) {
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("err.jsp").forward(request, response);

            }

        }
        //修改
        if (flag.equals("updateUser")) {

            String name = request.getParameter("s_username");
            String password = request.getParameter("s_password");
            String email = request.getParameter("s_email");
            String s_grade = request.getParameter("s_grade");
            int grade = Integer.parseInt(s_grade);
            User user = new User();
            user.setUsername(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setGrade(grade);
            UserDaoSQLServerImpl userDaoSQLServer = new UserDaoSQLServerImpl();
            if (userDaoSQLServer.update(user)==1){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        }

        //添加
        if (flag.equals("insertUser")) {

            String s_name = request.getParameter("username");
            String s_password = request.getParameter("password");
            String s_email = request.getParameter("email");
            String s_grade = request.getParameter("grade");
            int grade = Integer.parseInt(s_grade);
            User user = new User();
            user.setUsername(s_name);
            user.setPassword(s_password);
            user.setEmail(s_email);
            user.setGrade(grade);

            UserDaoSQLServerImpl userDaoSQLServer = new UserDaoSQLServerImpl();
            if (userDaoSQLServer.insert(user)==1){
                request.getRequestDispatcher("success.jsp").forward(request,response);
            }else {
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
