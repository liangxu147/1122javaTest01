<%--
  Created by IntelliJ IDEA.
  User: 周公
  Date: 2022/4/22
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="LoginServlet" method="post">
    <table border="1px" cellspacing="0" align="center" width="400px">
        <tr>
            <td colspan="2">
                    <span style="color: red">
                        <c:if test="${param.msg=='pleaselogin'}">
                            请登录
                        </c:if>
                        <c:if test="${param.msg == 'paramerror'}">
                            用户名或密码输入有误！
                        </c:if>
                    </span>
            </td>
        </tr>
        <tr>
            <td align="right">
                用户名
            </td>
            <td>
                <input type="text" name="username" id="username" placeholder="请输入用户名">
            </td>
        </tr>
        <tr>
            <td align="right">
                密码
            </td>
            <td>
                <input type="password" name="password" id="password" placeholder="请输入密码">
            </td>
        </tr>
        <tr align="center">
            <td colspan="2">
                <input type="submit" value="登录">
                <a href="insert.jsp">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
