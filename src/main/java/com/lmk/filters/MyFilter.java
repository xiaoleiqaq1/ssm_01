package com.lmk.filters;

import com.lmk.constants.SysConstants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/11
 */
@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String uri = request.getRequestURI();
        if (!(uri.endsWith("index.jsp") || uri.endsWith("login/login") || uri.endsWith("getCode") ||
                uri.contains("/css") || uri.contains("/js"))) {
            Object attribute = request.getSession().getAttribute(SysConstants.GETGETSESSION);
            if (attribute == null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }

        filterChain.doFilter(request, response);
    }
}
