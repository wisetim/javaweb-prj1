<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/10/10
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册页面</title>
    <script type="text/javascript" src="check.js"></script>
</head>
<body>
<div align="center">
    <h3>用户注册</h3>
    <%--注册失败的消息--%>
    ${requestScope.regMsg}
    <%--用户注册的表单--%>
    <form action="register" method="post" onsubmit="return checkForm()">
        <table border="0">
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" id="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
