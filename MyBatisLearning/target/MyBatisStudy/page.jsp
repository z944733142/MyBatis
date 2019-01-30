<%@ page import="com.pojo.PageInfo" %>
<%@ page import="com.pojo.Flower" %>
<%--<%@ page isELIgnored="false" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        校园导航
    </title>
</head>
<body>
    <table border="1px">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>msg</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="asd">
        <tr>
            <td>${asd.id}</td>
            <td>${asd.name}</td>
            <td>${asd.address}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
