<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/10/10
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录页面</title>
</head>
<body>
<div align="center">
    <h3>用户登录</h3>
    <form action="login" method="post">
        <table border="0">
            <tr>
                <td>请输入用户名密码：</td>
                <td><input type="text" name="username"><br></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
