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
//        用于测试回退浏览器重新提交，和用户多次超快速点击提交的两种表单重复提交情况。
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String code = req.getParameter("code");
        // 比较Session中存放的验证码也就是页面上显示的图片验证码 与 页面提交(用户填入)的验证码是否一致
        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库:" + req.getParameter("username"));
//            用于测试请求转发后按下F5发起最后一次请求造成表单重复提交的情况。
//            req.getRequestDispatcher("/ok.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        } else {
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        }
    }
}
// 结论：这三种表单重复提交的情况都可以通过验证码来解决，但是验证完第一次一定要立即删除Session中的验证码。