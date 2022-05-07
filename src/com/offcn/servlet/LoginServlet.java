package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserServiceImpl us = new UserServiceImpl();
        User user = us.findUserByUnameAndPw(username, password);

        Cookie cookie1 = new Cookie("username", username);
        Cookie cookie2 = new Cookie("password", password);
        cookie1.setMaxAge(24*60*60);
        cookie2.setMaxAge(24*60*60);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        if (user!=null){
            //获得session
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("index.jsp");
        }else {
            response.sendRedirect("login.jsp?msg=paramerror");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
