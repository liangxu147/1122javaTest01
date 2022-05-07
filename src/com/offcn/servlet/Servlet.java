package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet( "/Servlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request 缓冲 解决中文乱码问题
        request.setCharacterEncoding("utf-8");
        //获取参数  （表单name）
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String uname = request.getParameter("uname");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        //创建对象  把或者参数封装到user
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(uname);
        user.setTelephone(Integer.parseInt(phone));
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        try {
            user.setBirthday(sdf.parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        UserDao ud=new UserDaoImpl();
        //调用方法
        ud.insertUser(user);
        //6、请求转发   请求转发是指当前资源完成工作后，将请求继续传递，传递给其他资源
        request.getRequestDispatcher("select.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
