package com.soft1841.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletFileTest2", urlPatterns = {"/ServletFileTest2"})
public class ServletFileTest2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //创建一个FileReader
        FileReader fr = new FileReader("d:\\myCounter.txt");
        BufferedReader br = new BufferedReader(fr);
        //读出一行数据
        String numVal = br.readLine();
        br.close();
        out.println(numVal);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
