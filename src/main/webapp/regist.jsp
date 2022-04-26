<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/2/28
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/JQuery/regist" method="get">
    用户名：<input type="text" name="username"><br>
    验证码：<input type="text" name="code"><br>
    <img src="http://localhost:8080/JQuery/kapatcha.jpg" style="width: 200px; height: 56px"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
