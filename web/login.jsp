<%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/9/23
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xml:base="login.jsp">
<head>
    <title>登录页面</title>
</head>
<body bgcolor="#00ffff">

<form action="LoginClServlet" method="get" align="center">
    <h3>用户登录</h3><br>
    用户名：<input type="text" name="username"><br><br>
    密  码：<input type="text" name="password"><br><br>
    <input type="submit" value="提交"><br>

</form>
</body>
</html>
