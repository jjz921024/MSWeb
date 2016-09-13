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
        <th>书名</th>
        <th>价格</th>
        <th>出版日期</th>
        <th>描述</th>
        <th>图片</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>


        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td><spring:eval expression="book.publicationDate"/></td>
                <td>${book.description}</td>
                <td>
                    <%-- <%= basePath %>resources/img/C++从入门到精通.jpg --%>
                    <img src="${book.imgPath}" width="128" height="128"/>
                </td>
                <td><a href="/book_edit/${book.id}">edit</a></td>
                <td><a href="/book_delete/${book.id}">delete</a></td>
            </tr>
        </c:forEach>

    <tr>
        <td><a href="/book_input">Add</a></td>
    </tr>
</table>
</body>
</html>
