<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Jun
  Date: 2016/9/5
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页</title>
  </head>

  <body onload='document.loginForm.username.focus();'>

      <div id="login-box">
         <h2>请输入您的用户名与密码</h2>
          <c:if test="${not empty error}">
              <div class="error">${error}</div>
          </c:if>
          <c:if test="${not empty logout}">
              <div class="logout">${logout}</div>
          </c:if>

      <form name="user" action="../j_spring_security_check" method="post">
        <table>
          <tr>
            <td>用户名</td>
            <td>
              <input type="text" id="j_username" name="j_username">
            </td>
          </tr>

          <tr>
            <td>密码</td>
            <td>
              <input type="password" id="j_password" name="j_password">
            </td>
          </tr>

          <tr>
            <td><input type="submit" value="登陆"></td>
            <td><a href="/reg/input">注册账户</a></td>
          </tr>

        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </div>
  </body>
</html>
