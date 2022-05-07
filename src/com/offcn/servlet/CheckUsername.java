package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        UserServiceImpl us = new UserServiceImpl();
        User user = us.CheckUserName(username);
        PrintWriter writer = response.getWriter();
        if (user==null){//没有用户  用户名可用
            writer.print("yes");
        }else {//存在此用户  用户名不可用
            writer.print("no");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
