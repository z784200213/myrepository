package com.demo.common;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SessionFilter implements Filter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    @Value("$(serverurl)")
    private String serverurl;
    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        patterns.add(Pattern.compile("login/index.html"));
        patterns.add(Pattern.compile("login/loginin"));
        patterns.add(Pattern.compile("login.do"));
        patterns.add(Pattern.compile("main/autoFillty_rj_situation.*"));
        patterns.add(Pattern.compile("main/post.*"));
        patterns.add(Pattern.compile(".*[(\\.js)||(\\.css)||(\\.png)]"));
        patterns.add(Pattern.compile("login.html"));
        patterns.add(Pattern.compile("UserInfor/login"));
        patterns.add(Pattern.compile("login/loginPost"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String token = httpRequest.getHeader("token");
        /*Cache cache=    CacheManager.getCacheInfo("token");
        if(token!=null){
            boolean bool=isAuth(token);
        }*/
        if (url.startsWith("/") && url.length() > 1) {
            url = url.substring(1);
        }
        if (isInclude(url)) {
            chain.doFilter(httpRequest, httpResponse);
            return;
            // httpResponse.sendRedirect("/login.html");
        } else {
            chain.doFilter(httpRequest, httpResponse);
            return;
          /*  if(!isAuth(token)){
                httpResponse.sendRedirect("/login/loginin");

                return;
            }else{
                chain.doFilter(httpRequest, httpResponse);
                return;
            }*/
          /*  HttpSession session = httpRequest.getSession();
            Cookie[] cookie=httpRequest.getCookies();
             Enumeration<String> strings=  httpRequest.getHeaderNames();
             Object loginname=session.getAttribute("loginName");
            if (session.getAttribute("loginName") != null&&token!=null){

                // session存在
                chain.doFilter(httpRequest, httpResponse);
                return;
            } else {
                // session不存在 准备跳转失败
                httpResponse.sendRedirect("/login/loginin");

                return;
            }*/
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 是否需要过滤
     *
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

    private boolean isAuth(String token) {
        if (token == null) {
            return false;
        }
        boolean bool = CacheManager.getSimpleFlag("token");
        if (bool) {
            Cache cache = CacheManager.getCacheInfo("token");
            Object obj = cache.getValue();
            if (obj.toString().equals(token)) {
                return true;
            }
            //CacheManager.clearOnly("token");
            return false;
            /*if(cache!=null){

            } else {
                CacheManager.clearOnly("token");
            }*/
        }
        return false;
    }

}
