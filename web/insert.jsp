<%--
  Created by IntelliJ IDEA.
  User: 79876
  Date: 2019/10/12
  Time: 7:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body bgcolor="#00ffff">
<center>

    <h5>
        添加用户
    </h5>
    <br>
    <h1>
        请输入用户信息
    </h1>
    <form action="UserClServlet?flag=insertUser" method="post">
        <table border="1" bgcolor="#00ffff">

            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" value=""></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password" value=""></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value=""></td>
            </tr>
            <tr>
                <td>grade:</td>
                <td><input type="text" name="grade" value=""></td>
            </tr>

            <td><input type="submit" value="添加"></td>
            </tr>

        </table>
    </form>


</center>
</body>
</html>
