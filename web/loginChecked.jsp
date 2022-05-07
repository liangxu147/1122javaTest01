0<%@ page import="com.offcn.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 周公
  Date: 2022/4/22
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--  获得session存储user对象 判断user是否存在  没有登录不存在：跳转到登录页面  --%>
<%
    HttpSession sess = request.getSession();
    User user = (User)sess.getAttribute("user");
    if(user == null){
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
