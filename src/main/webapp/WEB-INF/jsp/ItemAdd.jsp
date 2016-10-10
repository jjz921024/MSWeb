<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/9/5
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加商品</title>
</head>

<body>
<form:form commandName="item" name="itemForm" action="/item/save" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>条目名</td>
            <td>
                <input type="text" id="itemName" name="itemName"/>
            </td>
            <td>
                <form:errors path="name"/>
            </td>
        </tr>

        <tr>
            <td>URL</td>
            <td>
                <input type="text" id="url" name="url"/>
            </td>
            <td></td>
            <%--<form:errors path="price"/>--%>
        </tr>

        <tr>
            <td>提醒方式</td>
            <td>
                <input type="checkbox" name="notice" value="email">Email提醒<br>
                <input type="checkbox" name="notice" value="weibo">微博提醒
            </td>
        </tr>


        <tr>
            <td><input type="submit" value="添加"/></td>
            <td><a href="/item/list">返回</a></td>
        </tr>

    </table>
</form:form>
</body>
</html>
