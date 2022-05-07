package com.offcn.filter;

import com.offcn.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/selectServlet","/index.jsp","/select.jsp"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //登录时设置登录信息到session 取user信息  当user不存在重新登录  存在登录过直接放行
        if (user==null){//没登陆
            response.sendRedirect("login.jsp?msg=pleaselogin");
        }else {//没登陆过
        chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
