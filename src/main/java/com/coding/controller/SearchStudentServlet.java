package com.coding.controller;

import com.coding.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //发sql语句查询学生信息
        //使用for循环生成查询到的数据做模拟
        //将查询到的结果放入request对象中，请求转发给前端jsp页面
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            studentList.add(new Student(i, "name", 20 + i, "1760097961" + i));
        }
        String scheme = req.getScheme();
        req.setAttribute("scheme", scheme);
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/studentInfo.jsp").forward(req, resp);
    }
}
