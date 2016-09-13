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
    <title>添加书籍</title>
</head>

<body>
<form:form commandName="book" name="book" action="/book_save" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>书名</td>
            <td>
                <input path="name" type="text" id="name" name="name"/>
            </td>
            <td>
                <form:errors path="name"/>
            </td>
        </tr>

        <tr>
            <td>价格</td>
            <td>
                <input type="text" id="price" name="price"/>
            </td>
            <td><form:errors path="price"/></td>
        </tr>

        <tr>
            <td>描述</td>
            <td>
                <input type="text" id="description" name="description"/>
            </td>
        </tr>

        <tr>
            <td>出版日期</td>
            <td>
                <input type="date" id="publicationDate" name="publicationDate"/>
            </td>
            <td><form:errors path="publicationDate"/></td>
        </tr>

        <tr>
            <td>图片</td>
            <td>
                <input type="file" id="img" name="img"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="保存"/></td>
            <td><a href="/book_list">返回</a></td>
        </tr>

    </table>
</form:form>
</body>
</html>
