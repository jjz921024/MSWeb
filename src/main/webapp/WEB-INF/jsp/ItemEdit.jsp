<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>编辑商品</title>
</head>
<body>
<form name="itemForm" action="/item/update/${itemForm.itemID}" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>条目名</td>
            <td>
                <input type="text" id="itemName" name="itemName" value=${itemForm.itemName} />
            </td>
        </tr>

        <tr>
            <td>URL</td>
            <td>
                <input type="text" id="url" name="url" value=${itemForm.url} />
            </td>
        </tr>

        <tr>
            <td>提醒方式</td>
            <td>
                <input type="checkbox" name="notice" value="email"
                    <c:forEach items="${itemForm.notice}" var="notice">
                        <c:if test="${notice == 'email'}">
                               checked="checked"
                        </c:if>
                    </c:forEach>
                >Email提醒<br>

                <input type="checkbox" name="notice" value="weibo"
                    <c:forEach items="${itemForm.notice}" var="notice">
                        <c:if test="${notice == 'weibo'}">
                               checked="checked"
                        </c:if>
                    </c:forEach>
                >微博提醒
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="修改"></td>
            <td><a href="/item/list">返回</a></td>
        </tr>

    </table>
</form>
</body>
</html>
