<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/9/6
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑书籍</title>
</head>
<body>
<form name="book" action="/book_update/${book.id}" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>书名</td>
            <td>
                <input type="text" id="name" name="name" value="${book.name}"/>
            </td>
        </tr>

        <tr>
            <td>价格</td>
            <td>
                <input type="text" id="price" name="price" value="${book.price}"/>
            </td>
        </tr>

        <tr>
            <td>描述</td>
            <td>
                <input type="text" id="description" name="description" value="${book.description}"/>
            </td>
        </tr>

        <tr>
            <td>出版日期</td>
            <td>
                <input type="date" id="publicationDate" name="publicationDate"/>
            </td>
        </tr>

        <tr>
            <td>图片</td>
            <td>
                <input type="file" id="img" name="img"/>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="更新"></td>
            <td><a href="/book_list">返回</a></td>
        </tr>

    </table>
</form>
</body>
</html>
