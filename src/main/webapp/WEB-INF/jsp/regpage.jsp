<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/10/9
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<div id="reg-box">
    <c:if test="${not empty regmessage}">
    <div class="message">${regmessage}</div>
    </c:if>


<form name="user" action="/reg/submit" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" id="name" name="name">
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td>
                <input type="password" id="password" name="password">
            </td>
        </tr>

        <tr>
            <td>电子邮箱</td>
            <td>
                <input type="text" id="email" name="email">
            </td>
        </tr>

        <tr>
            <td>微博</td>
            <td>
                <input type="text" id="weibo" name="weibo">
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="注册"></td>
            <td><a href="/auth/login">返回</a></td>
        </tr>

    </table>
</form>
</div>
</body>
</html>
