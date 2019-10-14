<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/9/30
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xml:base="updateUser.jsp">

<html>
<head>
    <title>修改用户界面</title>
</head>
<body bgcolor="#f0f8ff">
<center>

    <h5>
        修改用户
    </h5>
    <br>
    <h1>
        请输入用户信息
    </h1>
    <form action="UserClServlet?flag=updateUser" method="post">
        <table border="1" bgcolor="#00ffff">
            <tr>
                <td>用户ID:</td>
                <td><input type="text" name="s_userId" value="<%=request.getParameter("userId")%>" readonly="readonly"></td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="s_username" value="<%=request.getParameter("username")%>"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="s_password" value="<%=request.getParameter("password")%>"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="s_email" value="<%=request.getParameter("email")%>"></td>
            </tr>
            <tr>
                <td>grade:</td>
                <td><input type="text" name="s_grade" value="<%=request.getParameter("grade")%>"></td>
            </tr>

            <td><input type="submit" value="修改用户"></td>
            <td><input type="reset" value="重置"></td>

            </tr>

        </table>
    </form>


</center>
</body>
</html>
