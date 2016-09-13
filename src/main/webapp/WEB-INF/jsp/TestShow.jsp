<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/9/5
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>书籍列表</title>
</head>

<body>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>


    <tr>
        <td><img src="<%= basePath %>resources/img/C++从入门到精通.jpg"/>
            <img src="${bo}"
        </td>
        <td>${user.password}</td>
    </tr>


</table>
</body>
</html>
