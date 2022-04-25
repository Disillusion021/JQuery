<%@ page import="com.coding.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 2022/1/23
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% response.setHeader("cache-control","no-cache"); %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 500px;
            margin: 0 auto;
            border: 1px solid black;
            border-collapse: collapse;
        }
        table td,th{
            border: 1px solid black;
            text-align: center;
        }
    </style>
</head>
<body>
<%--    <%--%>
<%--        List<Student> studentList = new ArrayList<Student>();--%>
<%--        for (int i = 0; i < 10; i++) {--%>
<%--            studentList.add(new Student(i+1,"name",i+21,"100086"+i));--%>
<%--        }--%>
<%--    %>--%>
    <%  List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>
    <%= request.getAttribute("scheme")%>
<table>
        <caption><h1>学生信息表</h1></caption>
        <thead>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>电话</th>
        </thead>
        <tbody>
        <% for (Student s : studentList) {%>
            <tr>
                <td><%= s.getId()%></td>
                <td><%= s.getName()%></td>
                <td><%= s.getAge()%></td>
                <td><%= s.getPhone()%></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</body>
</html>
