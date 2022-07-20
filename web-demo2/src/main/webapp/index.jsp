<%--
  Created by IntelliJ IDEA.
  User: chuliangda
  Date: 2022/7/18
  Time: 18:30
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
<div align="center">
    <table align="center" border="3" >
        <tr>
            <th>编号</th>
            <th>品牌名称</th>
            <th>品牌描述</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${brands}" var="brand">
            <tr>
                <td>${brand.id}</td>
                <td>${brand.name}</td>
                <td>${brand.description}</td>
                <c:if test="${brand.status==1}"><td>启用</td></c:if>
                <c:if test="${brand.status==0}"><td>禁用</td></c:if>
                <td><a href="/ServletSelectById?id=${brand.id}">修改</a> <a href="/ServletDeleteById?id=${brand.id}">删除</a> </td>
            </tr>
        </c:forEach>
    </table><br>
    <a href="/addHtml.html" >新增数据</a>

</div>
</body>
</html>

