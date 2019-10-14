package com.soft1841.controller;

import com.soft1841.model.User;
import com.soft1841.model.UserDaoSQLServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "LoginClServlet", urlPatterns = {"/LoginClServlet"})
public class LoginClServlet extends HttpServlet {
//    private static final long seriaLVersionUIN=1L;
    public void init(){
        try {
            //创建一个FileReader
            FileReader fr = null;
            fr = new FileReader("d:\\myCounter.txt");
            BufferedReader br = new BufferedReader(fr);
            //读出一行数据
            String numVal = br.readLine();
            br.close();
            this.getServletContext().setAttribute("visitTimes",numVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
            System.out.println(lists);
            int pageCount = userdao.searchCount();
            //要把lists中数据带入Welcome页面中
            request.setAttribute("result", lists);
            request.setAttribute("pageCount", pageCount + "");
            request.setAttribute("pageNow", "1");
            System.out.println(username + password);
            hs.setAttribute("username", username);
            request.getRequestDispatcher("main.jsp").forward(request, response);

        } else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String times = this.getServletContext().getAttribute("visitTimes").toString();
        this.getServletContext().setAttribute("visitTimes",(Integer.parseInt(times)+1)+"");
        doPost(request, response);
    }

    public void destory(){
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter("D:\\myCounter.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(this.getServletContext().getAttribute("visitTimes").toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
