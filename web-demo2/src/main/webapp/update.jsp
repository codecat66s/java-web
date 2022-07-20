<%--
  Created by IntelliJ IDEA.
  User: chuliangda
  Date: 2022/7/19
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div name="updateBrandDiv" align="center">
    <h1>修改商品</h1>
    <form action="/ServletUpdateBrand" method="post" name="updateBrand">
        <input type="hidden" name="id" value="${brand.id}">
        <p>品牌名称：<input type="text" name="name" value="${brand.name}"></p>
        <P>品牌描述：<textarea rows="8" cols="15" name="description">${brand.description}</textarea></P>
        <p>状态：
            <c:if test="${brand.status == 1}">
            <input type="radio" name="status" value="1" checked="checked">启用  <input type="radio" name="status" value="0">禁用</p>
    </c:if>
        <c:if test="${brand.status == 0}">
            <input type="radio" name="status" value="1">启用  <input type="radio" name="status" value="0" checked="checked">禁用</p>
        </c:if>
        <p><input type="submit" value="提交"></p>
    </form>
</div>

</body>
</html>
