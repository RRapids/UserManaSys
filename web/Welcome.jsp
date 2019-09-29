<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/9/23
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xml:base="Welcome.jsp">
<head>
    <title>网页</title>
</head>
<body>
<%
    String u = (String) session.getAttribute("username");
    //如果用户没有登录
    if (u==null){
        //用户非法登录，返回登录界面
        response.sendRedirect("login.jsp?err=1");
    }
%>
<center>
<%=session.getAttribute("username")%>
    登录成功 恭喜你！！<%=(String)session.getAttribute("username")%><br>
    登录成功 恭喜你！！<%=request.getParameter("username")%>
    <br><a href="login.jsp">重新登陆</a>

    <%
        List<HashMap> lists = new ArrayList<HashMap>();
        lists = (ArrayList) request.getAttribute("result");
    %>
    <table border=1>
        <tr>
            <td>用户Id</td><td>用户名</td><td>用户密码</td><td>用户等级</td>
            <td>修改用户</td><td>删除用户</td>
        </tr>
         <% for (int i = 0;i<lists.size();i++){%>
                <tr>
                    <td><%=lists.get(i).get("userId")%></td>
                    <td><%=lists.get(i).get("username")%></td>
                    <td><%=lists.get(i).get("password")%></td>
                    <td><%=lists.get(i).get("grade")%></td>
                </tr>
            <%}%>
    </table><br>
    <%
        //接受用户希望显示的页面，显示第几页
        String s_pageNow = (String) request.getAttribute("pageNow");
        int pageNow = Integer.parseInt(s_pageNow);
        if (pageNow!=1){
            out.print("<a href=UserClServlet?flag=fenye&pageNow="+(pageNow-1)+">上一页</a>");
        }
    %>
</center>
</body>
</html>
