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
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>商品列表</title>
</head>

<body>

<div>当前登录用户 : <sec:authentication property="name"/></div>

<table border="1">
    <tr>
        <th>条目名</th>
        <th>商品名</th>
        <th>URL</th>
        <th>当前价格</th>
        <th>最低价格</th>
        <th>创建日期</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>

        <%--遍历条目名--%>
        <c:forEach items="${listForms}" var="listForm">
            <tr>
                <td>${listForm.itemName}</td>
                <td>${listForm.productName}</td>
                <td>${listForm.url}</td>
                <td>${listForm.currentPrice}</td>
                <td>${listForm.buttomPrice}</td>
                <td><spring:eval expression="listForm.createDate"/></td>
                <td><a href="/item/edit/${listForm.itemID}">edit</a></td>
                <td><a href="/item/delete/${listForm.itemID}">delete</a></td>
            </tr>
        </c:forEach>

    <tr>
        <td><a href="/item/input">Add</a></td>
    </tr>
</table>
</body>
</html>
