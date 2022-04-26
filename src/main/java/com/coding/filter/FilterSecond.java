package com.coding.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterSecond implements Filter {
    public FilterSecond() {
        System.out.println("1. 先执行FilterSecond()构造器方法");
    }
    public void init(FilterConfig config) throws ServletException {
        System.out.println("2. 再执行init(FilterConfig filterConfig)初始化方法FilterSecond");
    }

    public void destroy() {
        System.out.println("4. 最后执行FilterSecond的destroy()方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("3. 再执行Filter的doFilter(ServletRequest request, ServletResponse response, FilterChain chain)过滤方法FilterSecond");
        chain.doFilter(request, response);
        System.out.println("FilterSecond chain.doFilter执行完的后置代码");
    }
}
