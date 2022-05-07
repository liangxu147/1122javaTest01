<%--
  Created by IntelliJ IDEA.
  User: 周公
  Date: 2022/4/22
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px" width="60%" align="center" cellspacing="0">
    <tr>
        <td>id</td>
        <td>用户名</td>
        <td>密码</td>
        <td>姓名</td>
        <td>手机号</td>
        <td>出生日期</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="u">
        <tr>
            <td>
                    ${u.id}
            </td>
            <td>
                    ${u.username}
            </td>
            <td>
                    ${u.password}
            </td>
            <td>
                    ${u.name}
            </td>
            <td>
                    ${u.telephone}
            </td>
            <td>
                    ${u.birthday}
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
