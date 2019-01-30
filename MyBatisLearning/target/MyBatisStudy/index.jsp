
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

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
        <c:forEach items="${PageInfo.list}" var="ip">
            <tr>
                <td>${ip.id }</td>
                <td>${ip.name }</td>
                <td>${ip.address }</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
