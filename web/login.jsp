<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/10/10
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户登录页面</title>
    <script type="text/javascript" src="check.js"></script>
</head>
<body>
<div align="center">
    <h3>用户登录</h3>
    <%--用户登录的表单--%>
    <form action="login" method="post" onsubmit="return checkForm()">
        <table border="0">
            <tr>
                <td>请输入用户名密码：</td>
                <td><input type="text" name="username" id="username"><br></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td>请选择用户类型：</td>
                <td>
                    <select name="type">
                        <option value="user">普通用户</option>
                        <option value="admin">管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登录"></td>
            </tr>
        </table>
        <p>还没有账号？<a href="${pageContext.request.contextPath}/register.jsp">注册</a></p>
    </form>
</div>
</body>
</html>
