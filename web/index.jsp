<%--
  Created by IntelliJ IDEA.
  User: 周公
  Date: 2022/4/25
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <div>
    <p align="left">
      <a href="selectServlet">查询${sessionScope.user.name}的信息</a>
    </p>
    <p align="center">欢迎${sessionScope.user.username}先生登录本网站</p>
    <p align="right">
      <a href="LogoutServlet">退出登录</a>
    </p>
  </div>
  </body>
</html>
