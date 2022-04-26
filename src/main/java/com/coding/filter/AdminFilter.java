package com.coding.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1. 先执行AdminFilter()构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2. 再执行init(FilterConfig filterConfig)初始化方法");
        Filter.super.init(filterConfig);
        // 1、获取Filter的名称 filter-name 的内容
        System.out.println("Filter的名称是：" + filterConfig.getFilterName());
        // 2、获取web.xml中配置的init-param初始化参数
        System.out.println("初始化参数email的值是：" + filterConfig.getInitParameter("email"));
        System.out.println("初始化参数address的值是：" + filterConfig.getInitParameter("address"));
        // 3、获取ServletContext对象
        System.out.println("获取ServletContext对象" + filterConfig.getServletContext());
    }

    /**
     * doFilter方法, 专门用于拦截请求。可以做权限检查。
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3. 再执行Filter的doFilter(ServletRequest request, ServletResponse response, FilterChain chain)过滤方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } else {
            // 让程序继续往下访问用户的目标资源。
            chain.doFilter(request, response);
            System.out.println("AdminFilter chain.doFilter执行完的后置代码");
        }
    }

    @Override
    public void destroy() {
        System.out.println("4. 最后执行AdminFilter的destroy()方法");
        Filter.super.destroy();
    }
}
