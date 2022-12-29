<form method="get" action="/cart">
    <body>


    <c:forEach var="d" items="${foods}" varStatus="i">
        <td><%=request.getAttribute("foods")%>
        </td>
        <td>${d.name}</td>

    </c:forEach>

    </body>
</form>