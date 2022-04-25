package com.coding.controller;

import com.coding.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends BaseServlet {
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if ("wyn".equals(username) && "wangxiaodan0622".equals(password)) {
            // 用户名密码验证成功，保存到cookie中
            Cookie cookie1 = new Cookie("username", username);
            // 当前cookie一星期有效
            cookie1.setMaxAge(60 * 60 * 24);
            Cookie cookie2 = new Cookie("password", password);
            cookie2.setMaxAge(60 * 60 * 24);
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            // 将用户信息保存到Session中
            User user = new User(1, username, password, "171451721@qq.com");
            req.getSession().setAttribute("user", user);
            System.out.println("登录成功");
        } else {
            // 用户名密码验证失败
            System.out.println("登录失败");
        }
        req.getRequestDispatcher("/cookie.html").forward(req, resp);
    }
}
