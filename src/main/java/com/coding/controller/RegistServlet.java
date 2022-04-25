package com.coding.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session中的验证p
        String token  = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        // 获取页面提交(用户填入)的验证码
        String code = req.getParameter("code");
        // 比较Session中存放的验证码也就是页面上显示的图片验证码 与 页面提交(用户填入)的验证码是否一致
        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库:" + req.getParameter("username"));
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        }
    }
}
