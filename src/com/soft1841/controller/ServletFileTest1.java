package com.soft1841.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.DoubleSummaryStatistics;

@WebServlet(name = "ServletFileTest1", urlPatterns = {"/ServletFileTest1"})
public class ServletFileTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //创建一个FileWriter
        FileWriter fileWriter = new FileWriter("D:\\myCounter.txt");
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write("123");
        //一定要关闭文件
        bw.close();
        out.println("Writer OK !");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
