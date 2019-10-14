<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %><%--
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
    <script type="text/javascript">
        function check() {
            return
        .
            window.confirm("你真的要删除吗？")
        }
    </script>
</head>

<body bgcolor="#00ffff">
<%
    String u = (String) session.getAttribute("username");
    //如果用户没有登录
    if (u == null) {
        //用户非法登录，返回登录界面
        response.sendRedirect("login.jsp?err=1");
    }
%>
<center>
    <%=session.getAttribute("username")%>
    登录成功 恭喜你！！<%=(String) session.getAttribute("username")%><br>
    登录成功 恭喜你！！<%=request.getParameter("username")%>

    <!--添加网页访问次数功能-->
    <%
        //创建一个FileReader
//        FileReader fr = new FileReader("d:\\myCounter.txt");
//        BufferedReader br = new BufferedReader(fr);
//        //读出一行数据
//        String numVal = br.readLine();
//        br.close();
//        int times = Integer.parseInt(numVal);
        //增加一次
//        times++;
//        //写入
//        FileWriter fileWriter = new FileWriter("D:\\myCounter.txt");
//        BufferedWriter bw = new BufferedWriter(fileWriter);
//        bw.write(times+"");
//        bw.close();
    %>
    <br><a href="login.jsp">重新登陆</a>

    <%
        List<HashMap> lists = new ArrayList<>();
        lists = (List<HashMap>) request.getAttribute("result");
    %>

    <table border="1">
        <tr>
            <td>用户Id</td>
            <td>用户名</td>
            <td>用户密码</td>
            <td>用户等级</td>
            <td>修改用户</td>
            <td>删除用户</td>

        </tr>

        <%for (int i = 0; i < lists.size(); i++) {%>
        <%
            int index = (int) lists.get(i).get("userId");
        %>
        <tr>
            <td><%=lists.get(i).get("userId")%>
            </td>
            <td><%=lists.get(i).get("username")%>
            </td>
            <td><%=lists.get(i).get("password")%>
            </td>
            <td><%=lists.get(i).get("grade")%>
            </td>
            <td>
                <a href="updateUser.jsp?username=<%=lists.get(i).get("username")%>&password=<%=lists.get(i).get("password")%>
            &grade=<%=lists.get(i).get("grade")%>&userId=<%=lists.get(i).get("userId")%>&email=<%=lists.get(i).get("email")%>">修改用户</a>
            </td>
            <td><a href="UserClServlet?flag=delUser&userId=<%=index%>" onclick="return check();">删除用户</a></td>

        </tr>
        <%}%>
    </table>
    //输入去那一页
    <form action="UserClServlet?flag=fenye" method="post">
        <input type="text" name="pageNow">
        <input type="submit" value="go">
    </form>
    <br>
    <%
        //接受用户希望显示的页面，显示第几页
        //页数
        String s_pageCount = (String) request.getAttribute("pageCount");
        int pageCount = Integer.parseInt(s_pageCount);
        for (int i = 1; i <= pageCount; i++) {
            out.println("<a href=UserClServlet?flag=fenye&pageNow=" + i + ">[" + i + "]</a>");
        }
        //上一页
        String s_pageNow = (String) request.getAttribute("pageNow");
        int pageNow = Integer.parseInt(s_pageNow);
        if (pageNow != 1) {
            out.print("<a href=UserClServlet?flag=fenye&pageNow=" + (pageNow - 1) + ">上一页</a>");
        }
        //下一页
        if (pageNow != pageCount) {
            out.println("<a href=UserClServlet?flag=fenye&pageNow=" + (pageNow + 1) + ">下一页</a>");
        }
    %>
    <br>
</center>
<%
    out.print("该网页被访问了："+this.getServletConfig().getServletContext().getAttribute("visitTimes")+"次。");
    out.print("你的IP地址为："+request.getRemoteAddr()+"<br>");
    out.print("你的机器名称是"+request.getRemoteHost()+"<br>");
%>

</body>
</html>
