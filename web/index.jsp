<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookService" class="cz.osu.books.app.BookService" scope="request"/>
<html>
<head>
    <title>Přehled knih</title>
</head>
<body>
<table>
    <tr>
        <th> Název knihy</th>
        <th> Autor knihy</th>
    </tr>
    <c:forEach var="book" items="${bookService.all}">
        <tr>
            <td>${book.title}</td>
            <td>${book.author}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
