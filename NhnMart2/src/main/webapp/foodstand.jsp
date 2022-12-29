<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>가격</th>
        <th>선택</th>
    </tr>
    <form method="post" action="/mart/cart">
        <c:forEach var="foods" items="${foods}" varStatus="i">
            <tr align="center">
            <td>${i.count}</td>
            <td>${foods.name}"</td>
            <td>${foods.price}</td>
                <td><input type="checkbox" name="items" value= +"${foods.name}"></td>
            </tr>
        </c:forEach>
    </form>
    <input type="submit" value="장바구니">
    <br><a href='/cart'>장바구니보기</a>
</table>
</body>
</html>
