<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/1/22
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope2.jsp页面</h1>
    pageContext域是否有值:<%=pageContext.getAttribute("key")%><br>
    request域是否有值:<%=request.getAttribute("key")%><br>
    session域是否有值:<%=session.getAttribute("key")%><br>
    application域是否有值:<%=application.getAttribute("key")%><br>
    student<%= request.getParameter("student")%>
    class<%= request.getParameter("class")%>
    lover<%= request.getParameter("lover")%>
</body>
</html>