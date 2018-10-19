package com.springboot005.core;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebFilter implements Filter {
    List<Pattern>patterns=new ArrayList<Pattern>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        patterns.add(Pattern.compile("serInfor/login"));
        patterns.add(Pattern.compile(".*[(\\.js)||(\\.css)||(\\.png)]"));
        patterns.add(Pattern.compile("error/auth"));
        patterns.add(Pattern.compile("userInfor/findAll"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        if (isInclude(url)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else {
            HttpSession session = httpRequest.getSession();
            Boolean sessionCheck = sessionCheck(session);
            if (sessionCheck) {
                // session存在
                filterChain.doFilter(httpRequest, httpResponse);
                return;
            } else {
                // session不存在 准备跳转失败
                httpResponse.sendRedirect("/error/auth");
                return;
            }
        }
    }

    /**
     * 判断请求是否需要过滤
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
    //session检查
    private boolean sessionCheck(HttpSession session) {
        Object obj = session.getAttribute("logintoken");
        if (obj != null) {
            return true;
        }
        return false;
    }

    //请求头检查
    private boolean headerCheck(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();

        return false;
    }

    //cookie检查
    private boolean cookieCheck(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return false;
    }
    @Override
    public void destroy() {

    }
}
