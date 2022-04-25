package com.coding.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().write("设置Session立即销毁");
    }
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置当前Session3秒后超时
        req.getSession().setMaxInactiveInterval(3);
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的生命周期是:" + maxInactiveInterval + "秒");
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取了Session默认的超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("Session的默认生命周期是:" + maxInactiveInterval + "秒");
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经向Session中存入键为key1的值");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session会话中取出key1的数据是：" + attribute);
    }

    protected void creatOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session会话对象
        HttpSession session = req.getSession();
        // 判断当前Session会话是否为新创建的还是之前创建的
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识id
        String sessionId = session.getId();

        resp.getWriter().write("得到的Session，它的id是：" + sessionId + "<br>");
        resp.getWriter().write("这个Session是否是新创建的" + isNew + "<br>");
    }
}
