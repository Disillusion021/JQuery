package com.coding.controller;

import com.coding.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{
    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("path1", "path1");
        cookie1.setPath(req.getContextPath());
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("path2", "path2");
        cookie2.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie2);
    }
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("lief3600", "lief3600");
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.getWriter().write("设置Cookie存活1h");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            // 设置MaxAge为0，即立即删除
            cookie.setMaxAge(0);
            // 通知浏览器
            resp.addCookie(cookie);
            resp.getWriter().write("Cookie立即删除(cookie2)");
        } else {
            resp.getWriter().write("没有找到cookie2");
        }
    }
    protected void defaultLife (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("测试Cookie生命周期");
    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key3", "value99");
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie修改成功");
    }
    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获得全部的cookie存入cookies数组
        Cookie[] cookies = req.getCookies();
        // 遍历cookies
        for (Cookie cookie : cookies) {
            // 打印全部cookie键值对
            resp.getWriter().write("Cookie[" + cookie.getName() + " = " + cookie.getValue() + "]<br/>");
        }
        // 获取指定的cookie对象
        Cookie wantCookie = null;
        // 假定一个想要的cookie的name为key3
        String wantCookieName = "key3";
        // 遍历cookies
        for (Cookie cookie : cookies) {
            // 判断每个cookie的name是否等于指定值
            if (cookie.getName().equals(wantCookieName)) {
                // 如果有指定的cookie，将其存入wantCookie中
                wantCookie = cookie;
                // 跳出循环
                break;
            }
        }
        // 判断wantCookie是否有取得指定的cookie
        if (wantCookie != null) {
            // 若wantCookie不为空，说明取得了指定cookie对象，打印输出到页面
            resp.getWriter().write("wantCookie[" + wantCookie.getName() + " = " + wantCookie.getValue() + "]<br/>");
        }

        // 使用CookieUtils工具类判断是否有指定的cookie
        wantCookie = CookieUtils.findCookie("key4", cookies);
        if (wantCookie != null) {
            resp.getWriter().write("wantCookie[" + wantCookie.getName() + " = " + wantCookie.getValue() + "]<br/>");
        }
    }
    protected void creatCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建Cookie对象
        Cookie cookie1 = new Cookie("key1", "value1");
        Cookie cookie2 = new Cookie("key2", "value2");
        Cookie cookie3 = new Cookie("key3", "value3");
        Cookie cookie4 = new Cookie("key4", "value4");
        Cookie cookie5 = new Cookie("key5", "value5");
        // 2.通知客户端保存Cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.addCookie(cookie4);
        resp.addCookie(cookie5);
        // 回传一句话
        resp.getWriter().write("Cookie创建成功");
    }
}
