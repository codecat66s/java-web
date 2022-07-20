<%--
  Created by IntelliJ IDEA.
  User: chuliangda
  Date: 2022/7/19
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        #loginError {
            color: red;
        }
    </style>
</head>
<body>
  <div align="center" name="userLoginDiv">
      <p>用户登录</p>
      <div id="loginError">${login_msg}</div>
      <form action="/ServletUserLogin" method="post" name="userLoginForm">
          <p>用户名：<input type="text" name="userName"></p>
          <p>用户密码：<input type="text" name="password"></p>
          <P>remember <input type="radio" name="rememberUser" value="remeber"></P>
          <P><input type="submit" value="登录"></P>
      </form>
  </div>
</body>
</html>
