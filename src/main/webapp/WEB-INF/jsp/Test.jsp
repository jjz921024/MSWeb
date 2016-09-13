<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/9/5
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>

<body>
<form name="user" action="/test" method="get">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" id="username" name="username">
            </td>
        </tr>

        <tr>
            <td>密码</td>
            <td>
                <input type="password" id="password" name="password">
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="保存"></td>
            <td><a href="/book_list">返回</a></td>
        </tr>

    </table>
</form>
</body>
</html>
