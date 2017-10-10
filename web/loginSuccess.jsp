<%@ page import="cn.edu.zjut.model.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2017/10/10
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    UserBean user = (UserBean)request.getAttribute("USER");
%>
<p align="center">登录成功，欢迎您，<%=user.getUsername()%>！</p>
</body>
</html>
