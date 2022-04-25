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
    <h1>scope.jsp页面</h1>
    <%
        // 往四个域中都分别保存了数据
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    pageContext域是否有值:<%=pageContext.getAttribute("key")%><br>
    request域是否有值:<%=request.getAttribute("key")%><br>
    session域是否有值:<%=session.getAttribute("key")%><br>
    application域是否有值:<%=application.getAttribute("key")%><br>
    <%
        // 请求转发,请求转发可以访问WEB-INF下资源，请求转发为只有一个request，共享一个request。"/"被服务器解析到工程路径
        request.getRequestDispatcher("./scope2.jsp").forward(request,response);
//        // 请求重定向，请求重定向不可以访问WEB-INF下资源，请求重定向发送两次请求，request不共享数据。"/"被浏览器解析到端口号
//        response.sendRedirect("/JQuery/scope2.jsp");
    %>
</body>
</html>
