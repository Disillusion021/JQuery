<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/1/23
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setHeader("cache-control","no-cache"); %>
<html>
<head>
    <title>Title</title>
    <style>
        /*tr{*/
        /*    collapse: collapse;*/
        /*    border: 1px solid black;*/
        /*    border-collapse: collapse;*/
        /*    !*表格的边框合并为一个单一的边框*!*/
        /*}*/
        table {
            width: 50%;
            margin: 0 auto;
            border-collapse: collapse;
        }
        table td {
            padding: 5px;
            border: 1px solid black;
        }
    </style>
</head>
<body>

<jsp:include page="scope2.jsp">
    <jsp:param name="student" value="wyn"/>
    <jsp:param name="class" value="3"/>
    <jsp:param name="lover" value="wyj"/>
</jsp:include>

<table>
    <caption>九九乘法表</caption>
    <thead></thead>
    <tbody>
    <%for (int i = 1; i < 10; i++) {%>
        <tr>
        <%for (int j = 1; j <= i; j++) {%>
            <td> <%= i + "x" + j + "=" + i * j%> </td>
        <% }%>
        </tr>
    <% }%>
    </tbody>
</table>
</body>
</html>
