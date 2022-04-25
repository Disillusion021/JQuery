<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/2/23
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://"
        + request.getServerName() + ":"
        + request.getServerPort()
        + request.getContextPath() + "/";%>
<html>
<head>
    <title>login</title>
    <base href="<%=basePath%>">
</head>
<body>
<%-- action = http://serverName/serverPort/JQuery/ --%>
<form action="login" method="get">
    <input type="hidden" name="action" value="login">
    用户名：<input type="text" name="username" id="username" value="${cookie.username.value}"><br>
    密码：<input type="text" name="password" id="password" value="${cookie.password.value}"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
